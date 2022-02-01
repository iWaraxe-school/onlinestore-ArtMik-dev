import java.util.Collections;
import java.util.List;

public class TopCommand implements command{

    @Override
    public void execute(List<Product> extractedProducts) throws InstantiationException, IllegalAccessException {
        Store comparatorProduct = new Store();;
        PriceComparator productPriceComparator = new PriceComparator();
        Collections.sort(extractedProducts, productPriceComparator);
        List<Product> finalList = extractedProducts.subList(0, 5);
        comparatorProduct.prettyProducts(finalList);
    }
}
