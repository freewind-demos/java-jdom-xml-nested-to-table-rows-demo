package demo;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.XSLTransformer;

import java.io.InputStream;

public class Hello {

  public static void main(String[] args) throws Exception {

    ClassLoader classLoader = Hello.class.getClassLoader();
    try (
        InputStream xsl = classLoader.getResourceAsStream("simple.xsl");
        InputStream xml = classLoader.getResourceAsStream("simple.xml")
    ) {

      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(xml);

      XSLTransformer transformer = new XSLTransformer(xsl);
      Document transformedDoc = transformer.transform(document);

      printXml(transformedDoc);
    }
  }

  private static void printXml(Document doc) throws Exception {
    XMLOutputter xmlOutput = new XMLOutputter();
    xmlOutput.setFormat(Format.getPrettyFormat());
    xmlOutput.output(doc, System.out);
  }

}
