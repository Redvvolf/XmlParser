package nurisezgin.com.xmlparser.xml;

import nurisezgin.com.xmlparser.xml.items.XmlDoc;
import org.xml.sax.Attributes;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public interface IXmlTagHandler {

    XmlDoc getDocument();

    void startDocument();

    void endDocument();

    void startElement(String tagName, Attributes attrs);

    void endElement(String tagName);

    void text(char[] chars, int offset, int len);

    void error(Exception e);

    void warning(Exception e);

}
