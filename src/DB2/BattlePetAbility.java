package DB2;

import Enums.PetSchool;
import java.io.IOException;

public class BattlePetAbility extends DB2Entry
{
    public int index;
    public PetSchool school;
    public int icon;
    public int cooldown;
    public int visualID; // ?
    public int turnID; // ?
    public String name;
    public String description;

    public BattlePetAbility(byte[] array) throws IOException
    {
        super(array);
        index = buffer.getInt();
        school = PetSchool.findByKey(buffer.getInt());
        icon = buffer.getInt();
        cooldown = buffer.getInt();
        visualID = buffer.getInt();
        turnID = buffer.getInt();
        name = DB2FileLoader.stringTable.get(buffer.getInt());
        description = DB2FileLoader.stringTable.get(buffer.getInt());
    }
}
