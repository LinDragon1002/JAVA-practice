public class MagicCard extends Card{
    public MagicCard(int damage, int health, int manaCost, String name, String content){
        super(damage,health,manaCost,"魔法",name,content);
    }
    @Override
    public String toString(){
        return "發動魔法卡: " + this.name;
    }
}
