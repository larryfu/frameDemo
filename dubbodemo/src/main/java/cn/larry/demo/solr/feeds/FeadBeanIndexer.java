package cn.larry.demo.solr.feeds;


import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by fugz on 2016/4/14.
 */
public class FeadBeanIndexer {


    private HttpSolrClient solrClient;

    private String solrUrl = "http://127.0.0.1:8983/solr/feeds";
    private String filePath = "C:\\Users\\fugz\\Desktop\\testfeeds.json";

    public FeadBeanIndexer() {
        this.solrClient = new HttpSolrClient(solrUrl);
    }

    public static void main(String[] args) throws IOException {

        new FeadBeanIndexer().indexFromFile();
    }


    public void indexFromFile() throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        List<Feed> feeds = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();
        lines.forEach(s -> {
            try {
                Feed fb = om.readValue(s, Feed.class);
                feeds.add(fb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Collection<FeedBean> feedBeans = new ArrayList<>();
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", 12, 1.0f);

//        List<SolrInputDocument> documents = new ArrayList<>();
//        feeds.forEach(f -> {
//            SolrInputDocument document = new SolrInputDocument();
//
//            document.setField("EI", f.EI);
//            document.setField("id", f.FeedId);
//            document.setField("feedContent", f.Content);
//            document.setField("participators", f.Participators);
//            document.setField("feedType", f.Type);
//            document.setField("createdDate", f.CreatedDate);
//            document.setField("creator", f.Creator);
//            documents.add(document);
//        });
        feeds.forEach(f -> {
            feedBeans.add(new FeedBean(f));
        });

        System.out.println(om.writeValueAsString(feedBeans));

        //  System.out.println(feedBeans);

        try {
            solrClient.addBeans(feedBeans);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

    }

}
