package nurisezgin.com.xmlparser.xml.items;


import nurisezgin.com.xmlparser.tools.Clerable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public class XmlTag implements Clerable {

    private final String tagName;
    private final HashMap<String, ?> attrs;
    private StringBuilder texts;
    private List<XmlTag> children;

    public XmlTag(String tagName, HashMap<String, ?> attrs) {
        if(tagName == null) {
            throw new IllegalArgumentException("TagName cannot be null");
        }
        this.tagName = tagName;
        this.attrs = attrs;
        texts = new StringBuilder();
        children = new ArrayList<XmlTag>();
    }

    public String tagName() {
        return tagName;
    }

    public HashMap<String, ?> attrs() {
        return attrs;
    }

    public String text() {
        return texts.toString();
    }

    public void addText(String text) {
        texts.append(text);
    }

    public List<XmlTag> getChild() {
        return children;
    }

    public void addChild(XmlTag child) {
        this.children.add(child);
    }

    public void clear() throws Exception {
        children.clear();
        attrs.clear();
        texts.delete(0, texts.length());
    }
}
