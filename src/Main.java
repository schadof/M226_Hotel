import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Menu menu = new Menu();
        RAWHandler RandW = new RAWHandler("player.txt");
        System.out.println("Welcome to Trails of Agony");
        Scanner in = new Scanner(System.in);
        System.out.println("Name of your adventurer");
        player.name = in.nextLine();
        RandW.add(player.name, "100");
        System.out.println("Hello brave " + player.name);
        menu.menu(player);
    }
}
