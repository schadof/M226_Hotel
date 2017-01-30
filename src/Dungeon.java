import java.util.Scanner;

public class Dungeon {

    Player player;

    public Dungeon(Player player){
        Enemy enemy = new Enemy();
        this.player = player;
    }

    public void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to do, " + player.name + "?");
        System.out.println("Health: " + player.health);
        System.out.println("1. Fight");
        System.out.println("2. Block");
        System.out.println("3. Run");
        switch(in.nextInt()){
            default:
                System.out.println("Invalid action");
                break;

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;
        }
    }
}
