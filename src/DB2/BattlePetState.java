package DB2;

import java.io.IOException;

public class BattlePetState extends DB2Entry
{
    public int index;
    public int unk1;
    public String name;
    public int defaultValue; // ?

    public BattlePetState(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        unk1 = buffer.getInt();
        name = DB2FileLoader.stringTable.get(buffer.getInt());
        defaultValue = buffer.getInt();
    }
}
