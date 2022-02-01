import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand implements command{


    @Override
    public void execute(List<Product> extractedProducts) throws IOException, InstantiationException, IllegalAccessException {
        Store comparatorProduct = new Store();
        Comparator<Product> productSortComparator = new NameComparator().thenComparing(new RateComparator().thenComparing(new PriceComparator()));
        Collections.sort(extractedProducts, productSortComparator);
        comparatorProduct.prettyProducts(extractedProducts);

    }
}
