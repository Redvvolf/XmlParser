package nurisezgin.com.xmlparser.tools;

import nurisezgin.com.xmlparser.xml.IXmlTagHandler;
import nurisezgin.com.xmlparser.xml.items.XmlDoc;
import nurisezgin.com.xmlparser.xml.items.XmlTag;
import org.xml.sax.Attributes;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public class DefaultXmlTagHandler implements IXmlTagHandler {

    private XmlDoc document;
    private XmlParserResultListener listener;

    public DefaultXmlTagHandler(XmlParserResultListener listener) {
        this.listener = listener;
    }

    public XmlDoc getDocument() {
        return document;
    }

    public void startDocument() {
        document = new XmlDoc();
    }

    public void endDocument() {
        try {
            listener.onXmlParseFinished((XmlDoc) document.clone());
            document.clear();
        } catch (Exception e) {
            error(e);
        }
    }

    public void startElement(String tagName, Attributes attrs) {
        XmlTag tag = new XmlTag(tagName, null);
        document.add(tag);
    }

    public void endElement(String tagName) {
        document.remove();
    }

    public void text(char[] chars, int offset, int len) {
        document.last().addText(new String(chars, offset, len));
    }

    public void error(Exception e) {
        listener.onError(e);
    }

    public void warning(Exception e) {
        listener.onWarning(e);
    }
}
