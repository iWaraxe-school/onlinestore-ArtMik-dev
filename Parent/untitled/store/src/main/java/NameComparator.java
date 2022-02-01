import java.util.Comparator;

public class NameComparator implements Comparator<Product> {

    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XML_Parser xmlParser = new XML_Parser();

        switch (xmlParser.getElementByTagName("name")) {
            case "asc":
                return secondProduct.getName().compareTo(firstProduct.getName());
            default:
                return firstProduct.getName().compareTo(secondProduct.getName());
        }
    }
}

