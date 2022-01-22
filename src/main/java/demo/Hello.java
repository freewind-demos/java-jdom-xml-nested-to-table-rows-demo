package demo;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.InputStream;
import java.util.List;

public class Hello {

  public static void main(String[] args) throws Exception {

    try (InputStream input = Hello.class.getClassLoader().getResourceAsStream("simple.xml")) {
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(input);

      Element root = document.getRootElement();
      System.out.println("### root: " + root.getName());

      List<Element> students = root.getChildren();
      System.out.println("----------------------------");

      for (Element student : students) {
        System.out.println("### student :" + student.getName());
        System.out.println("### id : " + student.getAttribute("id").getValue());
        System.out.println("### First Name : " + student.getChild("firstname").getText());
      }
    }

  }

}
