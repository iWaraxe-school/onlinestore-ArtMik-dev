import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class storeApp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {

        Store store = new Store();
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category: store.getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }

        while(true){
            System.out.println("Hi! Available commands: sort, top, order and exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

            if(userCommand.equalsIgnoreCase("sort")) {
                List<Product> tempProductList = new ArrayList<>(extractedProducts);
                Comparator<Product> comp = new ProductComparator().thenComparing(new ProductComparator());
                tempProductList.sort(comp);
                for (Product p:tempProductList) {
                    System.out.println("--------------------------------------------");
                    System.out.println("NAME: " + p.getName() + " PRODUCTS: " + p.getPrice());
                }

            }
            else if(userCommand.equalsIgnoreCase("print")){
                for (Product p:extractedProducts) {
                    System.out.println("--------------------------------------------");
                    System.out.println("NAME: " + p.getName() + " PRODUCTS: " + p.getPrice());
                }
            } else if(userCommand.equalsIgnoreCase("top")){
                List<Product> tempProductList = new ArrayList<>(extractedProducts);
                Comparator<Product> comp = new ProductComparator().thenComparing(new ProductComparator()).reversed();
                tempProductList.sort(comp);
                for (int i = 0; i < 5 && tempProductList.get(i) != null; i++) {
                    System.out.println("--------------------------------------------");
                    System.out.println(" NAME: " + tempProductList.get(i).getName() + " PRODUCTS: " + tempProductList.get(i).getPrice());
                }

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

