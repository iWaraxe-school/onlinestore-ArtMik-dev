import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Spice extends Category{
    private String Spice;
    public List<Product> products;

    public Spice(String Spice, List<Product> products) {
        this.Spice = Spice;
        this.products = products;
    }
    public Spice() {
    }

    @Override
    public String toString() {
        return "/Spice/\n" + StringUtils.join(products, "- ");
    }
}


