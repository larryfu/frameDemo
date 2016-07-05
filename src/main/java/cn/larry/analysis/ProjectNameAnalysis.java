package cn.larry.analysis;

import cn.larry.Dao.HibernateDaoUtil;
import cn.larry.entity.Projects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

import java.util.List;

/**
 * Created by Thinkpad on 2015/11/19.
 */
public class ProjectNameAnalysis {

    public static final String PROJECT_NAME = "projectName";

    private static  AttributePattern proNamePattern = new AttributePattern(PROJECT_NAME);

    public void analysis(List<String> names){
        names.forEach(proNamePattern::analysisOnce);
    }

    public double caculateSimilarity(String str){
        String[] strs = IKSpliter.splitString(str);
        for(String s:strs){
          //  if(s.length()>2)
        }
        return 0;
    }

    public void analysisFormDB(){
        HibernateDaoUtil hdl = new HibernateDaoUtil();
        System.out.println("startTime:" + LocalTime.now());
        List<Object> lens = hdl.find("select count(id) from " + Projects.class.getName());
        long len = (Long) lens.get(0);
        int step = 5000;
        for (int i = 0; i < len; i += step) {
            List<Projects> projects = hdl.pageSearch(Projects.class, i,  step);
            projects.forEach((p) -> {

                String[] mainInfo = p.getMainInfo().split("：");
                if (mainInfo.length > 0)
                    proNamePattern.analysisOnce(mainInfo[mainInfo.length - 1]);
            });
        }
       // proNamePattern.removeOnlyOneElements();
        System.out.println(proNamePattern.getAvgLength());
        System.out.println(proNamePattern.getAvgWordNumber());

        try {
            System.out.println(new ObjectMapper().writeValueAsString(proNamePattern.getWordOccurrence()));
            String str = new  ObjectMapper().writeValueAsString(proNamePattern);
            File file = new File(this.getClass().getResource("/").getFile()+"/proNamePattern.json");
            FileUtils.write(file, str, StandardCharsets.UTF_8);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hdl.getSessionFactory().close();
        System.out.println("endTime:" + LocalTime.now());
    }

    public static void main(String[] args) {
        //new ProjectNameAnalysis().analysisFormDB();
        File file = new File(ProjectNameAnalysis.class.getResource("/proNamePattern.json").getFile());

        String[] examples = {
                "南京市城郊地区社区居家养老现状及问题浅析（大学生创新实践省级项目）",
                "花语水岸",
                "物联网仓储系统",
                "基于Android的音乐播放器",
                "在线英汉词典",
                "基于UDP的多人聊天室",
                "环氧/多巯基型透明无色胶粘剂的研制",
                "紫外光固化水性聚氨酯涂料的合成与研究（企业项目）",
                "中日专利翻译",
                "雅居乐地产瑞丽国际花园",
                "中国建设银行远程柜员座席系统",
                "金蝶握手网",
                "武汉市广州本田景田销售有限公司"};
        try {
            AttributePattern ap = new ObjectMapper().readValue(file, AttributePattern.class);
            for(String s :examples){
                System.out.println(ap.similarity(s,2)+"  "+s);
            }

            for(int i =0;i<100;i++)
                System.out.println(i+"weight:"+ap.getWeight(i));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
