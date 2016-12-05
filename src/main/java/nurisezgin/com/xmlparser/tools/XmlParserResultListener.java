package nurisezgin.com.xmlparser.tools;


import nurisezgin.com.xmlparser.xml.items.XmlDoc;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public interface XmlParserResultListener {

    void onXmlParseFinished(XmlDoc doc);

    void onError(Exception e);

    void onWarning(Exception e);

}
