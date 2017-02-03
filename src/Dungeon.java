import java.util.Scanner;

public class Dungeon {

    Player player;
    Enemy enemy = new Enemy();
    Menu menu = new Menu();
    Scanner in = new Scanner(System.in);

    public Dungeon(Player player){
        this.player = player;
    }

    public void menu(){
        System.out.println("------------------------------");
        System.out.println("What do you want to do, " + player.name + "?");
        System.out.println("Your Health: " + player.health);
        System.out.println("Enemy Health: " + enemy.health);
        System.out.println("1. Fight");
        System.out.println("2. Block");
        System.out.println("3. Run");
        System.out.println("------------------------------");
        switch(in.nextLine()){
            default:
                System.out.println("Invalid action");
                menu();
                break;

            case "1":
                //dodge/block chance
                if(Math.random() * 100 <= 30){
                    //counter chance
                    if(Math.random() * 100 <= 40){
                        int damage = (int)(Math.random() * 5);
                        player.damage(damage);
                        System.out.println("------------------------------");
                        System.out.println("The enemy countered for " + damage + " damage");
                        kill();
                        menu();
                    }
                    //damage reduction
                    int damage = (int)(Math.random() * 5);
                    enemy.damage(damage);
                    System.out.println("------------------------------");
                    System.out.println("The enemy blocked and only took " + damage + " damage");
                    kill();
                } else {
                    //normal damage
                    int damage = (int)(Math.random() * 20);
                    enemy.damage(damage);
                    System.out.println("------------------------------");
                    System.out.println("You damaged the enemy for " + damage + " damage");
                    kill();
                }
                menu();
                break;

            case "2":
                //dodge/block chance
                if(Math.random() * 100 <= 60){
                    //counter chance
                    if(Math.random() * 100 <= 50){
                        int damage = (int)(Math.random() * 5);
                        enemy.damage(damage);
                        System.out.println("------------------------------");
                        System.out.println("You countered for " + damage + " damage");
                        kill();
                    } else {
                        //normal damage
                        int damage = (int) (Math.random() * 5);
                        player.damage(damage);
                        System.out.println("------------------------------");
                        System.out.println("You blocked and only took " + damage + " damage");
                        kill();
                    }
                }
                menu();
                break;

            case "3":
                //flee chance
                if(Math.random() * 100 <= 20){
                    System.out.println("------------------------------");
                    System.out.println("You fled");
                    menu.menu(player);
                } else {
                    //damage on failed flee
                    int damage =  (int)(Math.random() * 10);
                    player.damage(damage);
                    System.out.println("------------------------------");
                    System.out.println("You could not flee");
                    System.out.println("------------------------------");
                    System.out.println("You took " + damage + " Damage");
                    kill();
                    menu();
                }
                break;
        }
    }

    public void kill(){
        //checking if enemy is alive
        if(enemy.health <= 0){
            System.out.println("------------------------------");
            System.out.println("You killed the enemy");
            System.out.println("Dou you want to continue?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            switch (in.nextLine()){
                default:
                    System.out.println("------------------------------");
                    System.out.println("Invalid option");
                    kill();
                    break;

                case "1":
                    menu.dungeon(player);
                    break;

                case "2":
                    menu.menu(player);
                    break;
            }
            //checking if player is alive
        } else if(player.health <= 0){
            System.out.println("You died");
            Main main = new Main();
            main.initialize();
        }
    }
}
