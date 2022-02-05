import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;
import java.util.Map;

public class ProductComparator implements Comparator<Product> {

    public Map<String, String> sortBy;

    public ProductComparator(Map<String, String> sortBy){
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Product a, Product b) {
        CompareToBuilder compareBuilder = new CompareToBuilder();

        for (Map.Entry<String, String> item : sortBy.entrySet()) {
            SortOrder sortOrder = (SortOrder.valueOf(sortBy.get(item.getKey())));
            try {
                if (sortOrder == SortOrder.ASC) {
                    compareBuilder.append(this.getPropertyValue(a, item.getKey()), this.getPropertyValue(b, item.getKey()));
                } else {
                    compareBuilder.append(this.getPropertyValue(b, item.getKey()), this.getPropertyValue(a, item.getKey()));
                }
            } catch (Exception e) {
                System.out.println("Error: Products were not compared. An exception was thrown with the message: " + e.getMessage());
                return 0;
            }
        }

        return compareBuilder.toComparison();
    }

    private String getPropertyValue(Product product, String property) throws Exception {

        try {
            String propertyValue = product.getClass().getField(property).get(product).toString();
            return propertyValue;
        }
        catch (NoSuchFieldException | IllegalAccessException ex){
            throw new Exception(ex);
        }
    }
}



