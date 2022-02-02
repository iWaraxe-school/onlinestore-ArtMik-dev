import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XML_Parser <documentBuilder>{


    public String getElementByTagName(String TagName){
        File file = new File("store.xml");
        DocumentBuilderFactory dbfa = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = dbfa.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = documentBuilder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return doc != null ? doc.getElementsByTagName(TagName).item(0).getTextContent():null;
    }
}
