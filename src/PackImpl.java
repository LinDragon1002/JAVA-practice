import java.util.ArrayList;
import java.util.List;

class PackImpl implements Pack {

    @Override
    public List<Card> getPack(){
        List<Card> card = new ArrayList<>();
        card.add(new Card(1,1,1,"角色", "史萊姆", "史萊姆雖然是魔物，但人畜無害"));
        card.add(new MagicCard(5,0,3,"火球術", "忍術!豪火球之術!"));
        card.add(new EquipCard(1,1,1,"皮革甲", "廉價的防具"));
        return card;
    }

    @Override
    public void sellCard(Object who){
        if (who instanceof RoleCard){
            System.out.println(((RoleCard)who).name + "被你賣掉了");
        }else if (who instanceof EquipCard){
            System.out.println(((EquipCard)who).name + "被你賣掉了");
        }else if (who instanceof MagicCard){
            System.out.println(((MagicCard)who).name + "被你賣掉了");
        }
    }
}
