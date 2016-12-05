package nurisezgin.com.xmlparser.xml;

import nurisezgin.com.xmlparser.tools.utils.StreamUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public final class XmlParser {

    private IXmlTagHandler xmlParser;

    public XmlParser(IXmlTagHandler xmlParser) {
        if (xmlParser == null) {
           throw new IllegalArgumentException("TagHandler cannot be null");
        }
        this.xmlParser = xmlParser;
    }

    public void parser(URI uri) throws Exception {
        InputStream is = null;
        try {
            is = uri.toURL().openStream();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(false);
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new XmlHandler(xmlParser));
            xmlReader.parse(new InputSource(is));
        } finally {
            StreamUtils.closeStreams(is);
        }
    }

}
