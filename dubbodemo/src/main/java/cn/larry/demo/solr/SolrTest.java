package cn.larry.demo.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.Before;
import org.junit.Test;


public class SolrTest {

    HttpSolrClient solrClient;

    private static Logger logger = org.apache.log4j.LogManager.getLogger(SolrTest.class);

    public static final String solrUrl = "http://120.76.146.233:8983/solr/test";

    //   private static final String URL = "http://127.0.0.1:8086/solr";

    // private HttpSolrServer server = null;

    @Before
    public void init() {
        solrClient = new HttpSolrClient(solrUrl);

        // 创建 server
        //server = new HttpSolrServer(URL);
    }

    /**
     * 添加文档
     */
    @Test
    public void addDoc() {

        SolrInputDocument doc = new SolrInputDocument();

        doc.addField("id", "11");
        doc.addField("title", "this is my document !!");

        try {

            UpdateResponse response = solrClient.add(doc);
            // 提交
            solrClient.commit();

            logger.info("########## Query Time :" + response.getQTime());
            logger.info("########## Elapsed Time :" + response.getElapsedTime());
            logger.info("########## Status :" + response.getStatus());

        } catch (SolrServerException | IOException e) {
            logger.error("", e);
        }
    }

    /**
     * 添加多个文档
     */
    @Test
    public void addDocs() {

        String[] titles = new String[]{"aaaaaaa", "bbbbbbb", "ccccccc", "dddddd", "eeeeee"};

        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();

        int i = 0;
        for (String str : titles) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", i++);
            doc.addField("title", str);
            docs.add(doc);
        }

        try {

            UpdateResponse response = solrClient.add(docs);
            solrClient.commit();

            logger.info("########## Query Time :" + response.getQTime());
            logger.info("########## Elapsed Time :" + response.getElapsedTime());
            logger.info("########## Status :" + response.getStatus());

        } catch (SolrServerException | IOException e) {
            logger.error("", e);
        }
    }

    /**
     * 添加一个Entity到索引库
     */
    @Test
    public void addBean() {

        Message msg = new Message("1001", "What is Fluentd?", new String[]{"Fluentd is an open source data collector for unified logging layer",
                "Fluentd allows you to unify data collection and consumption for a better use and understanding of data.",
                "Fluentd decouples data sources from backend systems by providing a unified logging layer in between.",
                "Fluentd proves you can achieve programmer happiness and performance at the same time. A great example of Ruby beyond the Web.",
                "Fluentd to differentiate their products with better use of data."});

        try {

            UpdateResponse response = solrClient.addBean(msg);
            solrClient.commit();

            logger.info("########## Query Time :" + response.getQTime());
            logger.info("########## Elapsed Time :" + response.getElapsedTime());
            logger.info("########## Status :" + response.getStatus());

        } catch (SolrServerException | IOException e) {
            logger.error("", e);
        }
    }

    /**
     * 添加多个Entity到索引库
     */
    @Test
    public void addBeans() {

        List<Message> msgs = new ArrayList<Message>();

        Message msg = new Message("1001", "What is Fluentd?", new String[]{"Fluentd is an open source data collector for unified logging layer",
                "Fluentd allows you to unify data collection and consumption for a better use and understanding of data.",
                "Fluentd decouples data sources from backend systems by providing a unified logging layer in between.",
                "Fluentd proves you can achieve programmer happiness and performance at the same time. A great example of Ruby beyond the Web.",
                "Fluentd to differentiate their products with better use of data."});

        Message msg2 = new Message("1002", "What is Fluentd?", new String[]{"Fluentd is an open source data collector for unified logging layer",
                "Fluentd allows you to unify data collection and consumption for a better use and understanding of data.",
                "Fluentd decouples data sources from backend systems by providing a unified logging layer in between.",
                "Fluentd proves you can achieve programmer happiness and performance at the same time. A great example of Ruby beyond the Web.",
                "Fluentd to differentiate their products with better use of data."});

        msgs.add(msg);
        msgs.add(msg2);

        try {

            UpdateResponse response = solrClient.addBeans(msgs);
            solrClient.commit();

            logger.info("########## Query Time :" + response.getQTime());
            logger.info("########## Elapsed Time :" + response.getElapsedTime());
            logger.info("########## Status :" + response.getStatus());

        } catch (SolrServerException | IOException e) {
            logger.error("", e);
        }
    }

    /**
     * 删除索引
     */
    @Test
    public void deleteDoc() {
        try {
            solrClient.deleteById("0");
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            logger.error("", e);
        }
    }

    /**
     * 更新索引<br>
     * solr索引库不同于数据库，没有更新的功能。如果想更新，先通过id删除对应的文档，再添加新的文档。
     */
    @Test
    public void updateDoc() {
        // ... ...
    }

    /**
     * 查询
     */
    @Test
    public void testQuery() {
        String queryStr = "*:*";
        SolrQuery params = new SolrQuery(queryStr);
        params.set("rows", 10);
        try {
            QueryResponse response = solrClient.query(params);
            SolrDocumentList list = response.getResults();
            logger.info("########### 总共 ： " + list.getNumFound() + "条记录");
            for (SolrDocument doc : list) {
                logger.info("######### id : " + doc.get("id") + "  title : " + doc.get("title"));
                System.out.println("######### id : " + doc.get("id") + "  title : " + doc.get("title"));
            }
        } catch (SolrServerException e) {
            logger.error("", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单查询(分页)
     */
    @Test
    public void querySimple() {
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", "this is");
        params.set("q.op", "and");
        params.set("start", 0);
        params.set("rows", 5);
        params.set("fl", "*,score");
        try {
            QueryResponse response = solrClient.query(params);
            SolrDocumentList list = response.getResults();
            logger.info("########### 总共 ： " + list.getNumFound() + "条记录");
            for (SolrDocument doc : list) {
                logger.info("######### id : " + doc.get("id") + "  title : " + doc.get("title"));
            }
        } catch (SolrServerException e) {
            logger.error("", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void highlight() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery("title:*is*");
        query.setHighlight(true);                //开启高亮
        query.setHighlightFragsize(10);          //返回的字符个数
        query.setHighlightRequireFieldMatch(true);
        query.setHighlightSimplePost("<aa>");    //前缀
        query.setHighlightSimplePre("</aa>");    //后缀
        query.setParam("hl.fl", "color");      //高亮字段
        QueryResponse req = solrClient.query(query);
        SolrDocumentList list = req.getResults();
        logger.info("########### 总共 ： " + list.getNumFound() + "条记录");
        list.forEach(doc -> {
            logger.info("######### id : " + doc.get("id") + "  title : " + doc.get("title") + ",content:" + doc.get("content"));
        });

        Map<String, Map<String, List<String>>> map = req.getHighlighting();
        map.forEach((k, v) -> {
            logger.info("############ id : " + k);
            v.forEach((k1, v1) -> {
                logger.info("############ subKey : " + k1);
                v1.forEach(s -> logger.info("############ subValues : " + s));
            });
        });
        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            Map<String, List<String>> values = map.get(key);
            logger.info("############################################################");
            logger.info("############ id : " + key);

            for (Map.Entry<String, List<String>> entry : values.entrySet()) {
                String subKey = entry.getKey();
                List<String> subValues = entry.getValue();

                logger.info("############ subKey : " + subKey);
                for (String str : subValues) {
                    logger.info("############ subValues : " + str);
                }
            }

        }
    }

    /**
     * 查询(分页,高亮)
     */
    @Test
    public void queryCase() {
        //    String queryStr = "title:*is*";

        SolrQuery params = new SolrQuery();
        params.set("q", "title:*is*");
        params.set("q.op", "and");

        params.set("start", 0);
        params.set("rows", 5);

        // 启用高亮组件, 设置高亮
        params.setHighlight(true)
                .addHighlightField("title")
                .setHighlightSimplePre("<span class=\"red\">")
                .setHighlightSimplePost("</span>")
                .setHighlightSnippets(2)
                .setHighlightFragsize(1000)
                .setStart(0)
                .setRows(10)
                .set("hl.useFastVectorHighlighter", "true")
                .set("hl.fragsize", "200");

        try {
            QueryResponse response = solrClient.query(params);
            SolrDocumentList list = response.getResults();
            logger.info("########### 总共 ： " + list.getNumFound() + "条记录");
            list.forEach(doc -> {
                logger.info("######### id : " + doc.get("id") + "  title : " + doc.get("title") + ",content:" + doc.get("content"));
            });

            Map<String, Map<String, List<String>>> map = response.getHighlighting();

            map.forEach((k, v) -> {
                logger.info("############ id : " + k);
                v.forEach((k1, v1) -> {
                    logger.info("############ subKey : " + k1);
                    v1.forEach(s -> logger.info("############ subValues : " + s));
                });
            });


        } catch (SolrServerException e) {
            logger.error("", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}