public class Entity {
    String name;
    int health = 100;

    public void heal(int amount){
        health += amount;
    }

    public void damage(int amount){
        health -= amount;
    }

}
