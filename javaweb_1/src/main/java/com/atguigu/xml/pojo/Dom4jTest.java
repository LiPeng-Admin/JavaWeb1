package com.atguigu.xml.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 9:53
 */
public class Dom4jTest {
    @Test
    public void test1() {
        //1:创建一个SAXReader输入流，去读取xml 配置文件，生成Document对象
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("src/main/resources/books.xml");
            System.out.println(document.toString());
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取books.xml文件生成Book类
     */

    @Test
    public void test2() throws DocumentException {
        //1:读取books.xml文件
        SAXReader saxReader = new SAXReader();
        //2:通过document对象获取根元素
        Document document = saxReader.read("src/main/resources/books.xml");


        //3:通过根元素获取book标签对象
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
//        System.out.println(rootElement);
        //4:遍历，处理每个book标签转换为Book类
    for(Element book : books){
        //asXML():将标签对象，转换为标签字符串
//        System.out.println(book.asXML());
        Element nameElement = book.element("name");
//        System.out.println(nameElement.asXML());
        //getText():获取标签中的文本内容
        String nameText = nameElement.getText();
//        System.out.println(nameText);

        //elementText():直接获取指定标签名中文本内容
        String priceText = book.elementText("price");
//        System.out.println(price);
        String author = book.elementText("author");

        String  snValue=book.attributeValue("sn") ;
        System.out.println(new Book(snValue,nameText,Double.parseDouble(priceText),author));

    }


    }
}
