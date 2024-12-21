import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class CreateXmlDocument{

    // コンストラクタ
    CreateXmlDocument(){
        //何もしない
    }

    //主処理
    public static void main(String args[]) throws Exception {
        // ここから処理
        Document document = createXMLDocument("book");
        Element element = document.getDocumentElement();

        // DOM要素の構築
        Element info = document.createElement("info");
        info.setAttribute("title", "Java入門");
        info.setAttribute("author", "shunya");
        info.setAttribute("date", "2016/06/27");
        info.setAttribute("version", "1.0");
        element.appendChild(info);

        // XML文字列として標準出力に出力
        System.out.println(createXMLString(document));

        //=> <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        //=> <book>
        //=>   <info author="shunya" date="2016/06/27" title="Java入門" version="1.0"/>
        //=> </book>
    }


    /*
    * XMLドキュメントを用意します<br/>
    * param 親タグ名
    * return XMLドキュメント
    */
    private static Document createXMLDocument(String root) throws ParserConfigurationException {
        // ドキュメント用に用意
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        DOMImplementation dom = builder.getDOMImplementation();
        return dom.createDocument("", root, null);
    }

    /*
    * XML形式の文字列を作成します<br/>
    * param XMLドキュメント
    * return XML文字列
    */
    private static String createXMLString(Document document) throws TransformerException {
        StringWriter writer = new StringWriter();
        TransformerFactory factory = TransformerFactory.newInstance(); 
        Transformer transformer = factory.newTransformer(); 

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");

        transformer.transform(new DOMSource(document), new StreamResult(writer)); 
        return writer.toString();
    }

}