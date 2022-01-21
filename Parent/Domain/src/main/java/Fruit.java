import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Fruit extends Category {

    private String fruit;
    public List<Product> products;

    public Fruit(String fruit, List<Product> products) {
        this();
        this.fruit = fruit;
        this.products = products;
    }
    public Fruit() {

        super("Fruit");
    }

    @Override
    public String toString() {

        return "\n / Fruit / \n" + StringUtils.join(products, "- ");
    }

}

