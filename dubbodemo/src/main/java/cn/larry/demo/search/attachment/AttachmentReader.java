package cn.larry.demo.search.attachment;

import cn.larry.demo.solr.feeds.TimeUtils;
import com.facishare.feeds.search.common.util.AnalyzerUtil;
import com.facishare.feeds.search.common.util.LangUtil;
import org.apache.commons.lang3.StringUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.facishare.feeds.search.common.util.FeedsCoverseUtil.joinAnalyzeredWords;

/**
 *
 * Created by fugz on 2016/4/21.
 */
public class AttachmentReader {

    public static void main(String[] args) throws IOException {
        //List<AttachmentBean> attachmentBeen = readFromCsvFile("C:\\Users\\fugz\\Desktop\\attach.csv");
       // System.out.println();
        System.out.println(analyzeWithIK("中华人民"));
    }

    public static List<String> analyzeWithIK(String text) throws IOException {
        ArrayList list = new ArrayList();
        if(StringUtils.isNotBlank(text)) {
            StringReader reader = new StringReader(text);
            IKSegmenter ik = new IKSegmenter(reader, true);
            Lexeme lexeme = null;

            while((lexeme = ik.next()) != null) {
                String word = lexeme.getLexemeText();
                if(!list.contains(word)) {
                    list.add(word);
                }
            }
        }

        return list;
    }


    public static List<AttachmentBean> readFromCsvFile(String filePath) throws IOException {
        List<String> attachLines = Files.readAllLines(Paths.get(filePath));
        List<AttachmentBean> attachments = new ArrayList<>();
        attachLines.forEach(s -> {
            try {
                attachments.add(convert2Bean(s));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return attachments;
    }

    private static String convertId(long origin, String convertEi) {
        String convertedAttachId = LangUtil.hashNumber(origin);
        return convertEi + convertedAttachId;
    }

    private static AttachmentBean convert2Bean(String s) {

        AttachmentBean attachment = new AttachmentBean();
        OriginAttachment oa = new OriginAttachment(s.split(","));
        //将Ei扩展到8位，最高位为1，再转换为36进制
        String convertedEi = LangUtil.hashEI(Long.parseLong(oa.getEI()));

        attachment.setId(convertId(Long.parseLong(oa.getAttachID()), convertedEi));

        //attachment.setFeedId(convertId(Long.parseLong(oa.getDataID()), convertedEi));

        attachment.setSenderId(convertId(Long.parseLong(oa.getEmployeeID()), convertedEi));

        String feedBeanDate = oa.getCreateTime();
        attachment.setCreateTime(TimeUtils.parseDate(feedBeanDate));

        String attachmentName = joinAnalyzeredWords(oa.getAttachName(), convertedEi);
        attachment.setFileName(attachmentName);
        return attachment;
    }
}
