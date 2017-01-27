public class Entity {
    String name;
    int health;

    public void heal(int amount){
        health += amount;
    }

    public void damage(int amount){
        health -= amount;
    }
}
