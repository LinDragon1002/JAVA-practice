public class RoleCard extends Card{

    private EquipCard equipCard;

    @Override
    public String toString(){
        return this.name;
    }

    public RoleCard(int damage, int health, int manaCost, String name, String content, EquipCard equipCard){
        super(damage,health,manaCost,"角色",name,content);
        System.out.println(toString() + "穿上裝備卡: " + equipCard.toString());
        this.equipCard = equipCard;
        super.health = super.health + equipCard.health;
        super.damage = super.damage + equipCard.damage;

    }

    public void getEquip(){
        equipCard.evaluate();
    }

    public String get(){
        return this.name + "身上的" + equipCard.name + "也被你賣掉了";
    }
}
