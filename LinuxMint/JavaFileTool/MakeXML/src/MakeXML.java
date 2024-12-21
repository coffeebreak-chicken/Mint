import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

class MakeXML {
    public MakeXML(){
	// コンストラクタ
	}

	public static void main(String[] args) {
		
        try {

            /*
            *アプリケーションでXMLドキュメントから
            *DOMオブジェクト・ツリーを生成するパーサーを取得できるファクトリAPIを定義します。
            */
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //ファクトリ・インスタンスを作成
            
            /*
            *このクラスのインスタンスを取得すると、
            *さまざまな入力ソースからXMLドキュメントを構文解析できます
            */
            DocumentBuilder builder = factory.newDocumentBuilder(); //インスタンスを取得する
            
            //DOMツリーの構築に使用するDOM Documentオブジェクトの新しいインスタンスを取得します。
            Document doc = builder.newDocument();

			// 親タグ定義：<info>
            Element root = doc.createElement("info");
            root.setAttribute("code", "A0001");
			doc.appendChild(root);

			// System.out.println(info);

			// 小タグ定義：<data>
            Element data = doc.createElement("data");

			// 小タグに要素を追加
            // data.appendChild(doc.createTextNode("Taro Yamada"));
            Text txt = doc.createTextNode("Taro Yamada Java入門");
            // txt.setTextContent("Java入門");
            // data.setAttribute("data", "A0001");
			// data.setAttribute("title", "Java入門");
			// data.setAttribute("date", "2024/03/31");
			// data.setAttribute("version", "1.0");
            data.appendChild(txt);

			// 親タグ(root="info")に子タグ(data)を結合
			root.appendChild(data);

            //子タグ2定義
            Element tag2 = doc.createElement("tag2");
            tag2.appendChild(doc.createTextNode("tag2 中身")); //小タグにノード追加
            //親タグ(root="info")に子タグ2を結合
            root.appendChild(tag2);



            /*
            *作成したノードツリーを変換する
            */
            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer tf = tfFactory.newTransformer();

            /*
            *インデント、エンコードの設定
            */
            tf.setOutputProperty("indent", "yes");
            tf.setOutputProperty("encoding", "UTF-8");

            //String型への出力準備
            StringWriter writer = new StringWriter();
            //Transformerを使って、第一引数を第二引数へ変換する
            tf.transform(new DOMSource(doc), new StreamResult(writer));//StringWriter経由して文字列へ変換
			System.out.println(writer.toString());
            tf.transform(new DOMSource(doc), new StreamResult(new File("/home/minty/デスクトップ/JavaFileTool/MakeXML/src/Sample.xml")));//ファイルへ出力

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

}