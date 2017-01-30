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
                menu(player);
                break;

            case 1:
                Dungeon dungeon = new Dungeon(player);
                dungeon.menu();
                break;

            case 2:
                if(player.health <= 200) {
                    for (int x = 10; x > 0; x--) {
                        System.out.println(x);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    player.heal(10);
                }
                menu(player);
                break;

            case 3:
                RAWHandler RandW = new RAWHandler("player.txt");
                RandW.add(player.name, Integer.toString(player.health));
                menu(player);
                break;

            case 4:
                System.out.println("Goodbye");
                break;
        }
    }
}
