import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Sushi extends Category{
    private String Sushi;
    public List<Product> products;

    public Sushi(String Sushi, List<Product> products) {
        this.Sushi = Sushi;
        this.products = products;
    }
    public Sushi() {
    }

    @Override
    public String toString() {
        return "\n/Sushi/\n" + StringUtils.join(products, "- ");
    }
}
