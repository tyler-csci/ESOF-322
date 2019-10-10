import java.util.*;

//simple display for client to use
public class Client {
    public void display_menu() {
        System.out.println ( "To store database using Graph, press 1");
        System.out.println("To store database using NoSQL, press 2");
        System.out.println("To store database using Relational, press 3");
        System.out.print ( "Selection: " );
    }

    //input utility for getting clients choice of store method
    public Client() {
        Database database = new Database(new Graph());
        Scanner in = new Scanner(System.in);

        display_menu();
        switch (in.nextInt()) {
            case 1:
                database.store();
                break;
            case 2:
                database.setStoreStrategy(new NoSQL());
                database.store();
                break;
            case 3:
                database.setStoreStrategy(new Relational());
                database.store();
                break;
            default:
            System.err.println ( "Error." );
            break;
        }
    in.close();
    }

    public static void main (String[] args) {
    new Client();
    }
}