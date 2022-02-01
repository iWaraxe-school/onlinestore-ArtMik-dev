import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class storeApp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {

        Store store = new Store();
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category: store.getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }


        int i = 1;
        while(i>=1){
            System.out.println("Hi! Available commands: sort, top, order and exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

            if(userCommand.equalsIgnoreCase("sort")) {

                command sortCommand = new SortCommand();
                sortCommand.execute(extractedProducts);

            }
            else if(userCommand.equalsIgnoreCase("top")){

                command topCommand = new TopCommand();
                topCommand.execute(extractedProducts);
            }
            else if (userCommand.equalsIgnoreCase("order")){

                Order orderCommand = new Order();
                orderCommand.execute(extractedProducts);

            }
            else if(userCommand.equalsIgnoreCase("quit")) {
                reader.close();
                System.out.println("See you soon!");
                System.exit(0);
            }
            else {
                System.out.println("The command was not recognized. Available commands: sort, top, exit. Please try again.");
            }
        }
    }
}

