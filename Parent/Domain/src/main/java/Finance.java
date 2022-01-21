import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Finance extends Category {

    private String finance;
    public List<Product> products;

    public Finance(String finance, List<Product> products) {
        this();
        this.finance = finance;
        this.products = products;
    }
    public Finance() {

        super("Finance");
    }

    @Override
    public String toString() {

        return "\n / Finance / \n" + StringUtils.join(products, "- ");
    }
}