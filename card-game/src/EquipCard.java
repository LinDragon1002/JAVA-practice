public class EquipCard extends Card{

    public EquipCard(int damage, int health, int manaCost, String name, String content){
        super(damage,health,manaCost,"裝備",name,content);

    }

    @Override
    public String toString(){
        return this.name;
    }
}
