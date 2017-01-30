import java.util.Scanner;

public class Dungeon {

    Player player;
    Enemy enemy = new Enemy();
    Menu menu = new Menu();

    public Dungeon(Player player){
        this.player = player;
    }

    public void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to do, " + player.name + "?");
        System.out.println("Your Health: " + player.health);
        System.out.println("Enemy Health: " + enemy.health);
        System.out.println("1. Fight");
        System.out.println("2. Block");
        System.out.println("3. Run");
        switch(in.nextInt()){
            default:
                System.out.println("Invalid action");
                menu();
                break;

            case 1:
                if(Math.random() * 100 <= 30){
                    if(Math.random() * 100 <= 40){
                        int damage = (int)(Math.random() * 5);
                        player.damage(damage);
                        System.out.println("The enemy countered for " + damage + " damage");
                        menu();
                    }
                    int damage = (int)(Math.random() * 5);
                    enemy.damage(damage);
                    System.out.println("The enemy blocked and only took " + damage + " damage");
                } else {
                    int damage = (int)(Math.random() * 20);
                    enemy.damage(damage);
                }
                menu();
                break;

            case 2:
                if(Math.random() * 100 <= 60){
                    if(Math.random() * 100 <= 50){
                        int damage = (int)(Math.random() * 5);
                        enemy.damage(damage);
                        System.out.println("You countered for " + damage + " damage");
                    } else {
                        int damage = (int) (Math.random() * 5);
                        player.damage(damage);
                        System.out.println("You blocked and only took " + damage + " damage");
                    }
                }
                menu();
                break;

            case 3:
                if(Math.random() * 100 <= 20){
                    System.out.println("You fled");
                    menu.menu(player);
                } else {
                    int damage =  (int)(Math.random() * 10);
                    player.damage(damage);
                    System.out.println("You took " + damage + " Damage");
                    menu();
                }
                break;
        }
    }
}
