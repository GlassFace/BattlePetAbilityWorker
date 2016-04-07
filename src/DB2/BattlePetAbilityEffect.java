package DB2;

import java.io.IOException;

public class BattlePetAbilityEffect extends DB2Entry
{
    public int index;
    public int turnID;
    public int visualID; // ?
    public int aura;
    public int effectPropertiesID;
    public int effectID;
    public int[] params = new int[6];

    public BattlePetAbilityEffect(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        turnID = buffer.getInt();
        visualID = buffer.getInt();
        aura = buffer.getInt();
        effectPropertiesID = buffer.getInt();
        effectID = buffer.getInt();
        
        for (int i = 0; i < 6; i++)
            params[i] = buffer.getInt();
    }
}
