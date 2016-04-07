package DB2;

import java.io.IOException;

public class BattlePetAbilityState extends DB2Entry
{
    public int index;
    public int ability;
    public int state;
    public int value;

    public BattlePetAbilityState(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        ability = buffer.getInt();
        state = buffer.getInt();
        value = buffer.getInt();
    }
}
