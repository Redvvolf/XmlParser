package nurisezgin.com.xmlparser.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by nurisezgin on 03/12/2016.
 */
class XmlHandler extends DefaultHandler {

    private IXmlTagHandler parser;

    public XmlHandler(IXmlTagHandler parser) {
        this.parser = parser;
    }

    @Override
    public void startDocument() throws SAXException {
        parser.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        parser.endDocument();
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        parser.startElement(s2, attributes);
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        parser.endElement(s2);
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        parser.text(chars, i, i1);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        parser.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        parser.error(e);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        parser.warning(e);
    }
}
