package cn.larry.demo.tika;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

import java.io.*;

/**
 * Created by fugz on 2016/8/1.
 */
public class TikaDocumentParser implements DocumentParser {

    public String parse(InputStream is) {
        try {
            BodyContentHandler handler = new BodyContentHandler();
            new AutoDetectParser().parse(is, handler, new Metadata(), new ParseContext());
            return handler.toString();//.replaceAll("\\?|\\t|\u00a0", " ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DocumentParser parser = new TikaDocumentParser();

        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\fugz\\Desktop\\com.txt")) {
            long start = System.currentTimeMillis();
            String txt = parser.parse(inputStream);
            System.out.println(txt);
            System.out.println("cost:" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
