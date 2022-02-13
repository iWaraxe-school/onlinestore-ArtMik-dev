

import Categories.Product;

import javax.xml.parsers.ParserConfigurationException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class StoreHelper {
    Store store;

    public ExecutorService executorService = Executors.newFixedThreadPool(3);
    public StoreHelper(Store store) {

        this.store = store;
    }
    public List<Product> sortAllProducts() throws Exception {
        Map<String, String> sortBy;
        try {
            XML_Parser xml = new XML_Parser();
            sortBy = xml.getAllPropertiesToSort();
        }
        catch (ParserConfigurationException e){
            throw new Exception();
        }
        return sortAllProducts(sortBy);

    }

    public List<Product> sortAllProducts(Map<String, String> sortBy) {

        List<Product> allProducts = this.store.getAllProducts();
        allProducts.sort(new ProductComparator(sortBy));

        return allProducts;
    }

    public List<Product> getTop5() {

        Map<String, String> sortBy = new HashMap<>();
        sortBy.put("price", SortOrder.DESC.toString());

        List<Product> sortedList = sortAllProducts(sortBy);
        List<Product> top5 = new ArrayList<>(sortedList.subList(0, 5));

        return top5;
    }
    public void createOrder(String productName) {

        System.out.printf(Thread.currentThread().getName());

        Product orderedProduct = getOrderedProduct(productName);
        int threadTime = new Random().nextInt(30);

        executorService.execute(() -> {
            try {
                System.out.printf("Starting order ", Thread.currentThread().getName());
                store.purchasedProductList.add(orderedProduct);

                store.printListProducts( store.purchasedProductList);

                Thread.sleep(threadTime * 1000);

                System.out.printf("Finishing order ", Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("createOrder() is finished " + Thread.currentThread().getName());
    }

    public void shutdownThreads(){
        executorService.shutdown();
    }

    private Product getOrderedProduct(String productName)
    {
        Optional<Product> orderedProduct =  store.getListOfAllProducts().stream().parallel()
                .filter(x -> x.name.equals(productName))
                .findFirst();

        Product product = orderedProduct.isPresent() ? orderedProduct.get() : null;

        return product;
    }
}
