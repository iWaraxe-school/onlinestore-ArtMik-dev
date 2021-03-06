package concoleApp;

import store.Store;
import store.StoreHelper;
import store.TimerCleanTask;
import store.populators.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
public class storeApp {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper(store);

        IPopulator populator = null;
        PopulatorEnum populatorType = PopulatorEnum.HttpPopulator;

        switch (populatorType) {
            case RandomStorePopulator:
                populator = new RandomStorePopulator();
                break;
            case DBPopulator:
                populator = new DBPopulator();
                break;
            case HttpPopulator:
                populator = new HttpPopulator();
                break;
        }
         store.fillStore(populator);
         store.printAllCategoriesAndProduct();

        Timer timer = new Timer();
        timer.schedule(new TimerCleanTask(store), 0, 60000);

        while (true) {

            System.out.println("Enter command sort/top/createOrder/quit:");
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
                case "createOrder":
                    System.out.println("Enter name of product to order:");
                    String productName = reader.readLine();
                    storeHelper.createOrder(productName);
                    break;
                case "addToCart":
                    System.out.println("Enter name of product to add to cart:");
                    String product = reader.readLine();

                    if (populator instanceof HttpPopulator) {
                        ((HttpPopulator) populator).addSoppingCart(product);

                        System.out.println("Products in the cart:");
                        store.printListProducts(((HttpPopulator) populator).getProductsInCart());
                    }
                    else {
                        System.out.println("'Add to Cart' command is not available for types other than HttpPopulator.");
                    }
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("The command is not recognized.");
            }
        }
    }
}


