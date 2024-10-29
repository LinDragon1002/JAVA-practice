public class Card {
    int damage;
    int health;
    int manaCost;
    String type;
    String name;
    String content;
    public Card(int damage, int health, int manaCost, String type, String name, String content){
        this.damage = damage;
        this.health = health;
        this.manaCost = manaCost;
        this.type = type;
        this.name = name;
        this.content = content;
    }
    public void evaluate(){
        System.out.println("名稱: "+ this.name);
        System.out.println("攻擊力: "+ this.damage);
        System.out.println("血量: "+ this.health);
        System.out.println("費用: "+ this.manaCost);
        System.out.println("卡片介紹: "+ this.content);
        if (this.damage > this.health){
            System.out.println("卡片評價: 這是一張攻擊型的角色卡");
        }else if (this.health > this.damage){
            System.out.println("卡片評價: 這是一張防守型的角色卡");
        }else{
            System.out.println("卡片評價: 這是一張攻守兼具的角色卡");
        }
    }

    public String getName(){
        return this.name;
    }
}
