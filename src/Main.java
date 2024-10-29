
public class Main {
    public static void main(String[] args) {
        Card card = new Card(1,1,1,"角色", "史萊姆", "史萊姆雖然是魔物，但人畜無害");
        card.evaluate();

        Player player = new Player("noob", "password", "新玩家");
        player.getInfo();
        player.addExp(1500);

        MagicCard magicCard = new MagicCard(5,0,3,"火球術", "忍術!豪火球之術!");
        System.out.println(magicCard);

        EquipCard equipCard = new EquipCard(1,1,1,"皮革甲", "廉價的防具");
        RoleCard roleCard = new RoleCard(1,1,1,"史萊姆","史萊姆雖然是魔物，但人畜無害", equipCard);

        roleCard.evaluate();
        roleCard.getEquip();

        Pack pack = new PackImpl();
        for(Card cardInPack : pack.getPack()){
            System.out.println("你抽到了: " + cardInPack.getName());
        }
        pack.sellCard(roleCard);
        pack.sellCard(magicCard);

        Pack pack2 = new RolePackImpl();
        pack2.sellCard(roleCard);

    }
}