import java.util.Comparator;

public class RateComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XML_Parser xmlParser = new XML_Parser();

        switch (xmlParser.getElementByTagName("price")) {
            case "desc":
                return Double.compare(secondProduct.getPrice(), firstProduct.getPrice());
            default:
                return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
        }
    }
}
