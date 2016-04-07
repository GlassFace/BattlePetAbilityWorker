package DB2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DB2FileLoader
{
    public static final int expectedHeader = 0x32424457;

    public static int header;
    public static int recordsCount;
    public static int fieldsCount;
    public static int recordSize;
    public static int stringTableSize;
    public static int tableHash;
    public static int build;
    public static int unk1;
    public static int minIndex;
    public static int maxIndex;
    public static int locale;
    public static int unk2;
    public static byte[][] rows;
    public static Map<Integer, String> stringTable = new HashMap<Integer, String>();

    public static void Load(String path) throws IOException
    {
        byte[] file = Files.readAllBytes(Paths.get(path));
        ByteBuffer buffer = ByteBuffer.wrap(file);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        header = buffer.getInt();
        
        if (header != expectedHeader)
            throw new IOException();
        
        recordsCount = buffer.getInt();
        fieldsCount = buffer.getInt();
        recordSize = buffer.getInt();
        stringTableSize = buffer.getInt();
        tableHash = buffer.getInt();
        build = buffer.getInt();
        unk1 = buffer.getInt();
        minIndex = buffer.getInt();
        maxIndex = buffer.getInt();
        locale = buffer.getInt();
        unk2 = buffer.getInt();
        
        if (maxIndex != 0)
        {
            int diff = maxIndex - minIndex + 1;
            buffer.position(buffer.position() + diff * 4 + diff * 2);
        }
        
        rows = new byte[recordsCount][recordSize];
         
        for (int i = 0; i < recordsCount; i++)
            buffer.get(rows[i]);
        
        int stringTableStart = buffer.position();
        while (buffer.position() != buffer.limit())
            stringTable.put(buffer.position() - stringTableStart, ReadString(buffer));
    }
    
    public static String ReadString(ByteBuffer buffer)
    {
        byte num;
        String text;
        java.util.ArrayList<Byte> temp = new java.util.ArrayList<Byte>();

        while ((num = buffer.get()) != 0)
            temp.add(num);

        byte[] bytes = new byte[temp.size()];
        for (int i = 0; i < bytes.length; i++)
            bytes[i] = temp.get(i);

        text = new String(bytes, StandardCharsets.UTF_8);
        return text;
    }
}
