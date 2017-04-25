package cn.larry.demo.solr.book;

import com.google.gson.Gson;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.solr.schema.TrieDateField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by fugz on 2016/6/24.
 */
public class BookImporter {

    public static void mains(String[] args) throws IOException {
        String path = "C:\\Users\\fugz\\Desktop\\books.json";
        List<String> strs = Files.readAllLines(Paths.get(path));
        String str = String.join("", strs);
        Gson gson = new Gson();
        List<Map<String, Object>> books = new ArrayList<>();
        books = gson.fromJson(str, books.getClass());
        //  books.get(0).getAuthors();
        List<Book> bookss = books.stream().map(Book::fromBook2).collect(Collectors.toList());
        List<Document> documents = bookss.stream().map(BookImporter::book2Ducument).collect(Collectors.toList());

        Directory dir = FSDirectory.open(Paths.get("D:\\home\\search\\books"));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);


        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);


        IndexWriter writer = new IndexWriter(dir, iwc);
        writer.addDocuments(documents);
        writer.commit();
        writer.close();

        System.out.println();
    }

    public static void main(String[] args) throws IOException, ParseException {
        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("D:\\home\\search\\books")));
        IndexSearcher searcher = new IndexSearcher(reader);
        searcher.setSimilarity(new ClassicSimilarity());
        Analyzer analyzer = new StandardAnalyzer();
        String field = "name";
        QueryParser parser = new QueryParser(field, analyzer);
        Query query = parser.parse("计算");

        TopDocs docs = searcher.search(query,10);
        System.out.println();
    }

    public static Document book2Ducument(Book book) {
        Document doc = new Document();
        if (book.getName() != null)
            doc.add(new TextField("name", book.getName(), Field.Store.YES));
        if (book.getId() != null)
            doc.add(new StringField("id", book.getId(), Field.Store.YES));
        if (book.getPress() != null)
            doc.add(new TextField("press", book.getPress(), Field.Store.YES));
        //if (book.getMark() != null)
        doc.add(new DoublePoint("mark", book.getMark()));
        doc.add(new DoublePoint("price", book.getPrice()));
        if (book.getAuthors() != null)
            for (String author : book.getAuthors()) {
                doc.add(new StringField("author", author, Field.Store.YES));
            }
        return doc;
    }
}
