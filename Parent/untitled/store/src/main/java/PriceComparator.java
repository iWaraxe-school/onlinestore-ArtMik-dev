import com.sun.org.apache.xerces.internal.parsers.XMLParser;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XML_Parser xmlParser = new XML_Parser();

        switch (xmlParser.getElementByTagName("rate")) {
            case "asc":
                return Integer.compare(secondProduct.getRate(), firstProduct.getRate());
            default:
                return Integer.compare(firstProduct.getRate(), secondProduct.getRate());
        }
    }
}
