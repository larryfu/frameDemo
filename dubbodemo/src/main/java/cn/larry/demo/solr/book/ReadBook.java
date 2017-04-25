package cn.larry.demo.solr.book;


import cn.larry.demo.Utils.TimeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

/**
 * Created by fugz on 2016/4/19.
 */
public class ReadBook {

    public static void main(String[] args) throws IOException, SolrServerException {
        String filePath = "C:\\Users\\fugz\\Desktop\\book.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            try {
                String[] ss = lines.get(i).split("\\|");
                Book book = toBook(ss);
                book.setId(i + "");
                books.add(book);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HttpSolrClient client = new HttpSolrClient("http://127.0.0.1:8080/solr/books");
        UpdateResponse response = client.addBeans(books);
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(books));
    }

    private static Book toBook(String[] ss) {
        Book book = new Book();
        book.setName(trim(ss[0]));
        String authorstr = ss[1];
        String[] authors = authorstr.split("/");
        List<String> authosList = new ArrayList<>();
        for (String s : authors)
            authosList.add(trim(s));
        book.setAuthors(authosList);
        book.setPress(trim(ss[2]));
        book.setPubTime(TimeUtils.getDate(trim(ss[3])));
        book.setPrice(Float.parseFloat(trim(ss[4]).replace("元", "")));
        book.setMark(Float.parseFloat(trim(ss[5])));
        return book;
    }
}
