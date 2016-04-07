package DB2;

import java.io.IOException;

public class BattlePetEffectProperties extends DB2Entry
{
    public int index;
    public int unk1;
    public String[] paramNames = new String[6];
    public int unk2; // probably default values
    public int unk3;
    public int unk4;
    public int unk5;
    public int unk6;
    public int unk7;

    public BattlePetEffectProperties(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        unk1 = buffer.getInt();
        
        for (int i = 0; i < 6; i++)
            paramNames[i] = DB2FileLoader.stringTable.get(buffer.getInt());
        
        unk2 = buffer.getInt();
        unk3 = buffer.getInt();
        unk4 = buffer.getInt();
        unk5 = buffer.getInt();
        unk6 = buffer.getInt();
        unk7 = buffer.getInt();
    }
}
