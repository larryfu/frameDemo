package cn.larry.demo.solr.feeds;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.io.IOException;

/**
 * Created by fugz on 2016/4/14.
 */
public class FeedBeanSearch {
    Logger logger = Logger.getLogger(FeedBeanSearch.class);
    private HttpSolrClient solrClient;

    public static void main(String[] args) {
        FeedBeanSearch search = new FeedBeanSearch();
        search.search();
    }

    private String solrUrl = "http://120.76.146.233:8080/solr/feed";

    public FeedBeanSearch() {
        this.solrClient = new HttpSolrClient(solrUrl);
    }

    public void search() {
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", "*:*");
        params.set("q.op", "or");
        params.set("start", 0);
        params.set("rows", 50);
//        params.set("gt","asd");
       // params.set("bf","ord(createdDate)");
//        params.set("sort","createdDate desc");
//        params.set("fl", "*,score");
        try {
            QueryResponse response = solrClient.query(params);
            SolrDocumentList list = response.getResults();
            logger.info("########### 总共 ： " + list.getNumFound() + "条记录");
            for (SolrDocument doc : list) {
                logger.info("id : " + doc.get("id")+",time:"+doc.get("createdDate")+",content:"+doc.get("feedContent"));
            }
        } catch (SolrServerException e) {
            logger.error("", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
