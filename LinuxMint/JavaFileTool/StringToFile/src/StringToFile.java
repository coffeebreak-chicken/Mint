import java.lang.StringBuilder;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.io.IOException;
public class StringToFile {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String id = "ID";
        String no = "NO";
        String para = "Para";

        sb.append(id);        sb.append("\n");
        sb.append(no);        sb.append("\n");
        sb.append(para);

        // Strを準備
        String sampleStr = sb.toString();
        // System.out.println(sampleStr);

        try{
        PrintWriter pw = new PrintWriter(
                          new BufferedWriter(
                          new OutputStreamWriter(
                          new FileOutputStream
                            ("/home/minty/デスクトップ/JavaFileTool/StringToFile/resource/Sample.xml"),"UTF-8")));
        pw.print(sampleStr);
        pw.close();

        }catch(IOException e){
        e.printStackTrace();
        }
    }
}
