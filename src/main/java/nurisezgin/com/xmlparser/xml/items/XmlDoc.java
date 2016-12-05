package nurisezgin.com.xmlparser.xml.items;


import nurisezgin.com.xmlparser.tools.Clerable;

import java.util.Stack;

/**
 * Created by nurisezgin on 03/12/2016.
 */
public class XmlDoc implements Cloneable, Clerable {

    private static final String ROOT_TAG_NAME = "root";
    private Stack<XmlTag> xmlTagStack;
    private XmlTag root;

    public XmlDoc() {
        root = new XmlTag(ROOT_TAG_NAME, null);
        xmlTagStack = new Stack<XmlTag>();
        xmlTagStack.push(root);
    }

    public XmlDoc(XmlTag root) {
        this.root = root;
    }

    public void add(XmlTag tag) {
        xmlTagStack.peek().addChild(tag);
        xmlTagStack.push(tag);
    }

    public boolean hasChildren() {
        return false;
    }

    public void collapse() {
        throw new IllegalStateException("Not imp yet...");
    }

    public XmlTag last() {
        return xmlTagStack.peek();
    }

    public XmlTag remove() {
        return xmlTagStack.pop();
    }

    public Stack<XmlTag> getXmlTagStack() {
        return xmlTagStack;
    }

    public XmlTag getRoot() {
        return root;
    }

    public void clear() throws Exception {
        xmlTagStack.clear();
        // TODO clear
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new XmlDoc(root);
    }
}
