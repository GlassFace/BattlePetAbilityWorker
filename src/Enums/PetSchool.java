package Enums;

public enum PetSchool
{
    NONE(-1),
    HUMANOID(0),
    DRAGONKIN(1),
    FLYING(2),
    UNDEAD(3),
    CRITTER(4),
    MAGIC(5),
    ELEMENTAL(6),
    BEAST(7),
    AQUATIC(8),
    MECHANICAL(9);

    private final int value;
    
    PetSchool(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public static PetSchool findByKey(int key)
    {
        for (PetSchool school : PetSchool.values())
            if (school.value == key)
                return school;
        
        return null;
    }
}
