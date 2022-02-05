import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class storeApp {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper(store);

//store.printListProducts(store.getAllProducts());
        while (true) {

            System.out.println("Enter command sort/top/quit:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();


            System.out.println("Your command is : " + command);
            switch (command) {
                case "sort":
                    store.printListProducts(storeHelper.sortAllProducts());
                    break;
                case "top":
                    System.out.println("Print top 5 products sorted via price desc.");
                    store.printListProducts(storeHelper.getTop5());
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("The command is not recognized.");
            }
        }
    }
}


