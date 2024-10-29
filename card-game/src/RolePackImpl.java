import java.util.ArrayList;
import java.util.List;

class RolePackImpl implements Pack{
    @Override
    public List<Card> getPack(){
        List<Card> card = new ArrayList<>();
        return card;
    }
    @Override
    public void sellCard(Object who){
        if (who instanceof RoleCard){
            System.out.println(((RoleCard)who).name + "被你賣掉了");
            System.out.println(((RoleCard)who).get());
        }else if (who instanceof EquipCard){
            System.out.println(((EquipCard)who).name + "被你賣掉了");
        }else if (who instanceof MagicCard){
            System.out.println(((MagicCard)who).name + "被你賣掉了");
        }
    }
}
