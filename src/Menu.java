public class Menu {
    String name;

    public void menu(String name) {
        Player player = new Player();
        player.name = name;
        this.name = name;
        System.out.println("Hello brave " + name);
    }
}
