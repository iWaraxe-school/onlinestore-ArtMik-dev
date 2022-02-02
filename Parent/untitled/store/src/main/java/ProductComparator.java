import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductComparator implements Comparator<Product> {
    public ProductComparator() throws InstantiationException, IllegalAccessException {
    }

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}