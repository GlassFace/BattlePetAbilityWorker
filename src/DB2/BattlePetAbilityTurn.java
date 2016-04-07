package DB2;

import java.io.IOException;

public class BattlePetAbilityTurn extends DB2Entry
{
    public int index;
    public int ability;
    public int visualID;
    public int turn;
    public boolean hasProcType;
    public int procType;

    public BattlePetAbilityTurn(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        ability = buffer.getInt();
        visualID = buffer.getInt();
        turn = buffer.getInt();
        hasProcType = buffer.getInt() == 1;
        procType = buffer.getInt();
    }
}
