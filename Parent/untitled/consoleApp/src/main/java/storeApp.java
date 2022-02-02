import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class storeApp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {


        Boolean flag = true;
        while (flag) {

            System.out.println("Enter command sort/top/quit:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            Store store = new Store();

            System.out.println("Your command is : " + command);
            switch (command) {
                case "sort":
                    store.productSort();
                    break;
                case "top":
                    System.out.println("Print top 5 products sorted via price desc.");
                    store.productTop();
                    break;
                case "quit":
                    flag = false;
                    break;
                default:
                    System.out.println("The command is not recognized.");
            }
        }
    }
}


