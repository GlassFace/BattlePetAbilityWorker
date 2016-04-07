package DB2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class DB2Stores
{
    public static List<BattlePetAbility> battlePetAbilityStore = new ArrayList<BattlePetAbility>();
    public static List<BattlePetAbilityEffect> battlePetAbilityEffectStore = new ArrayList<BattlePetAbilityEffect>();
    public static List<BattlePetAbilityState> battlePetAbilityStateStore = new ArrayList<BattlePetAbilityState>();
    public static List<BattlePetAbilityTurn> battlePetAbilityTurnStore = new ArrayList<BattlePetAbilityTurn>();
    public static List<BattlePetEffectProperties> battlePetEffectPropertiesStore = new ArrayList<BattlePetEffectProperties>();
    public static List<BattlePetState> battlePetStateStore = new ArrayList<BattlePetState>();
    
    public static Map<Integer, List<BattlePetAbilityEffect>> abilityEffectsByAbilityTurn = new HashMap<Integer, List<BattlePetAbilityEffect>>();
    public static Map<Integer, List<BattlePetAbilityTurn>> abilityTurnsByAbility = new HashMap<Integer, List<BattlePetAbilityTurn>>();
    
    public static void LoadStores()
    {
        try
        {
            DB2FileLoader.Load("BattlePetAbility.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetAbilityStore.add(new BattlePetAbility(row));

            DB2FileLoader.Load("BattlePetAbilityEffect.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetAbilityEffectStore.add(new BattlePetAbilityEffect(row));

            DB2FileLoader.Load("BattlePetAbilityState.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetAbilityStateStore.add(new BattlePetAbilityState(row));
            
            DB2FileLoader.Load("BattlePetAbilityTurn.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetAbilityTurnStore.add(new BattlePetAbilityTurn(row));
            
            DB2FileLoader.Load("BattlePetEffectProperties.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetEffectPropertiesStore.add(new BattlePetEffectProperties(row));
            
            DB2FileLoader.Load("BattlePetState.db2");
            for (byte[] row : DB2FileLoader.rows)
                battlePetStateStore.add(new BattlePetState(row));
            
            for (BattlePetAbilityEffect effect : battlePetAbilityEffectStore)
            {
                List<BattlePetAbilityEffect> list = abilityEffectsByAbilityTurn.get(effect.turnID);
                if (list == null)
                    list = new ArrayList<BattlePetAbilityEffect>();
                
                list.add(effect);
                abilityEffectsByAbilityTurn.put(effect.turnID, list);
            }
            
            for (BattlePetAbilityTurn turn : battlePetAbilityTurnStore)
            {
                List<BattlePetAbilityTurn> list = abilityTurnsByAbility.get(turn.ability);
                if (list == null)
                    list = new ArrayList<BattlePetAbilityTurn>();
                
                list.add(turn);
                abilityTurnsByAbility.put(turn.ability, list);
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "An error occured, shutting down!");
            e.printStackTrace();

            System.exit(1);
        }
    }
}
