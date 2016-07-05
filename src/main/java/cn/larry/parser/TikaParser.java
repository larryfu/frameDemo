package cn.larry.parser;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.parser.microsoft.OfficeParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * Created by Thinkpad on 2015/12/4.
 */
public class TikaParser {

    public static final String INPATH = "C:\\Users\\Thinkpad\\Desktop\\新建文件夹\\简历—付光增.docx";
    public static final String OUTPATH = "d:\\data.txt";

   // public static void main(String[] args) throws IOException, SAXException,
       //     TikaException {
        // 针对97-2003的microsoft office使用
        // Parser parser = new OfficeParser();
        // 针对microsoft office 2007及其以后的版本，使用
        // Parser parser = new OOXMLParser();
        // 或简单的使用AutoDetectParser
       // parseFile(INPATH, OUTPATH);
        public static void main(final String[] args) throws IOException,SAXException, TikaException {

            //detecting the file type
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(new File(INPATH));
            ParseContext pcontext = new ParseContext();

            //Html parser
           // HtmlParser htmlparser = new HtmlParser();
            Parser parser = new AutoDetectParser();
            parser.parse(inputstream, handler, metadata,pcontext);
            System.out.println("Contents of the document:" + handler.toString());
            System.out.println("Metadata of the document:");
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                System.out.println(name + ":   " + metadata.get(name));
            }
        }
   // }

    public static boolean parseFile(String inFile, String outFile) {
        boolean result = false;
        try (InputStream in = new BufferedInputStream(new FileInputStream(new File(inFile)));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outFile)))) {

            // 设置metadata
            Metadata meta = new Metadata();
            // meta.add(Metadata.CONTENT_ENCODING, "utf-8");
          //  meta.set(Metadata.RESOURCE_NAME_KEY, inFile);


            // 设置contentHandler (可以替换为WriteOutContentHandler)
            ContentHandler handler = new BodyContentHandler(out);

            // 创建parser
            Parser parser = new AutoDetectParser();

            // 解析文档
            parser.parse(in, handler, meta, new ParseContext());

            // 打印metadata信息
            for (String name : meta.names()) {
                System.out.println(name + ":" + meta.get(name));
            }
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }

}
