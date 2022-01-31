import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XML_Parser {


    public Map<String, String> XML_Parser() throws IOException, ParserConfigurationException, SAXException {
        File file = new File("store.xml");
        Map<String, String> xmlData = new LinkedHashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = dbf.newDocumentBuilder().parse(file);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                xmlData.put(((Element) nodeList.item(i)).getTagName(), nodeList.item(i).getTextContent());
            }
        }

        return xmlData;
    }

}
