import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RAWHandler RandW = new RAWHandler("player.txt");
        Player player = new Player();
        Menu menu = new Menu();
        System.out.println("Welcome to Trails of Agony");
        Scanner in = new Scanner(System.in);
        System.out.println("Name of your adventurer");
        player.name = in.nextLine();
        if(RandW.read().containsKey(player.name)){
            System.out.println("Restore Savegame");
            player.health = Integer.parseInt(RandW.hm.get(player.name));
        } else {
            player.health = 100;
        }
        System.out.println("Hello brave " + player.name);
        menu.menu(player);
    }
}
