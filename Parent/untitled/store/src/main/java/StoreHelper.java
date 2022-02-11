

import Categories.Product;

import javax.xml.parsers.ParserConfigurationException;
import java.util.*;


public class StoreHelper {
    Store store;

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
            throw new Exception("Error: Config file exception.");
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

}
