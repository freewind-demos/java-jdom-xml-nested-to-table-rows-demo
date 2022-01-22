package demo;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathFactory;

import java.io.InputStream;

public class Hello {

  public static void main(String[] args) throws Exception {

    try (InputStream input = Hello.class.getClassLoader().getResourceAsStream("simple.xml")) {
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(input);

      XPathFactory xpath = XPathFactory.instance();

      // attributes
      for (Attribute attrIds : xpath.compile("//class/student/@id", Filters.attribute()).evaluate(document)) {
        System.out.println("### id: " + attrIds.getValue().trim());
      }

      // values
      for (Element name : xpath.compile("//class/student/firstname", Filters.element()).evaluate(document)) {
        System.out.println("### name: " + name.getValue().trim());
      }

    }

  }

}
