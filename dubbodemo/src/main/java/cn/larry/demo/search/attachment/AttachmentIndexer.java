package cn.larry.demo.search.attachment;


import com.google.gson.Gson;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * Created by fugz on 2016/4/21.
 */
public class AttachmentIndexer {

    public static void mains(String[] args) throws IOException {
        Gson gson = new Gson();
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\fugz\\Desktop\\attach.csv"));
        List<String> attachLines = new ArrayList<>();
        lines.stream().map(AttachmentIndexer::fromStr).filter(d->d!=null).map(gson::toJson).forEach(attachLines::add);
        Files.createFile(Paths.get("d:\\attach.json"));
        Files.write(Paths.get("d:\\attach.json"), attachLines);
    }

    private static AttachData fromStr(String s) {
        try {
            AttachData data = new AttachData();
            OriginAttachment oa = new OriginAttachment(s.split(","));
            data.setSenderId(Long.parseLong(oa.getEmployeeID()));
            data.setEI(Long.parseLong(oa.getEI()));
            data.setAttachId(Long.parseLong(oa.getAttachID()));
            data.setAttachName(oa.getAttachName());
            data.setCreateTime(oa.getCreateTime().split("\\.")[0]);
            List<Long> paticipators = new ArrayList<>();
            Random random = new Random();
            int num = random.nextInt(10);
            for (int i = 0; i < num + 1; i++)
                paticipators.add((long) random.nextInt(10000));
            data.setParticipators(paticipators);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) throws IOException, SolrServerException {
        HttpSolrClient client = new HttpSolrClient("http://10.23.132.1:8081/solr/attachment");
        List<AttachmentBean> attachmentBeen = AttachmentReader.readFromCsvFile("C:\\Users\\fugz\\Desktop\\attach.csv");
        List<String> lines = new ArrayList<>();
        attachmentBeen.forEach(b -> {
            lines.add(new Gson().toJson(b));
        });
//        Path path = Paths.get("d:\\attach.json");
//        Files.createFile(path);
//        Files.write(path, lines);
        UpdateResponse response = client.addBeans(attachmentBeen);
        System.out.println();
    }
}
