package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/16 18:18
 */

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("./src/books.xml");
        System.out.println(read);
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("./src/books.xml");
        Element rootElement = read.getRootElement();
        List<Element> books = rootElement.elements("book");

        for (Element book : books) {
            Element nameElement = book.element("name");
            String name = nameElement.getText();

            String price = book.elementText("price");
            String author = book.elementText("author");

            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn, name, BigDecimal.valueOf(Double.parseDouble(price)), author));

        }
    }
}
