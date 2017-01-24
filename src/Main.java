import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Trails of Agony");
        Scanner in = new Scanner(System.in);
        System.out.println("Name of your adventurer");
        Menu menu = new Menu();
        menu.menu(in.nextLine());
    }
}
