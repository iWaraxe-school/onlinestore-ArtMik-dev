import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Hobbit extends Category{
    private String hobbit;
    public List<Product> products;

    public Hobbit(String hobbit, List<Product> products) {
        this();
        this.hobbit = hobbit;
        this.products = products;
    }
    public Hobbit() {

        super("Hobbit");
    }

    @Override
    public String toString() {

        return "\n / Hobbit / \n" + StringUtils.join(products, "- ");
    }
}
