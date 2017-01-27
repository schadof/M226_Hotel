import java.util.Scanner;

public class Menu {
    public void menu(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to do, " + player.name + "?");
        System.out.println("Health: " + player.health);
        System.out.println("1. Go to dungeon");
        System.out.println("2. Rest&Recover");
        System.out.println("3. Save");
        System.out.println("4. Exit");
        switch(in.nextInt()){
            default:
                System.out.println("Invalid action");
                break;

            case 1:

                break;

            case 2:
                for(int x=10; x>0; x--) {
                    System.out.println(x);
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                player.health += 10;
                menu(player);
                break;

            case 3:
                RAWHandler RandW = new RAWHandler("player.txt");
                RandW.add(player.name, Integer.toString(player.health));
                break;

            case 4:
                break;
        }
    }
}
