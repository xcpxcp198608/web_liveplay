package com.wiatec.liveplay.common.utils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author patrick
 */
public class XmlReader {

    private Logger logger = LoggerFactory.getLogger(XmlReader.class);

    public static void main (String [] args){
        XmlReader xmlReader = new XmlReader(PathUtil.getResourcePath() + "authorize.xml");
        xmlReader.listRoot();
    }

    private Document document;
    private Element root;

    public XmlReader(String xmlPath) {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(new File(xmlPath));
            root = document.getRootElement();
        } catch (DocumentException e) {
            logger.error("Exception: ", e);
            e.printStackTrace();
        }
    }

    public void listRoot(){
        listNodes(root, 0);
    }

    public void listNodes(Element node, int count){
        String s = " ";
        for(int i = 0; i < count; i ++){
            s += s;
        }
        logger.debug(s + "Node ：{}", node.getName());
        List<Attribute> attributeList = node.attributes();
        for(Attribute attribute : attributeList){
            logger.debug(s + "  attribute: "+attribute.getName() + " - value: " + attribute.getValue());
        }
        if(! "".equals(node.getTextTrim())){
            logger.debug(s + "  value: " + node.getText());
        }
        Iterator<Element> iterator = node.elementIterator();
        if(iterator.hasNext()) {
            count++;
        }
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e, count);
        }
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Element getRoot() {
        return root;
    }

    public void setRoot(Element root) {
        this.root = root;
    }
}
