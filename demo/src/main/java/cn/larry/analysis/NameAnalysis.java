package cn.larry.analysis;

import cn.larry.Dao.HibernateDaoUtil;
import cn.larry.entity.Projects;
import cn.larry.entity.Workexperiences;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Thinkpad on 2015/12/3.
 */
public class NameAnalysis {


    public double caculateSimilarity(String str) {
        String[] strs = IKSpliter.splitString(str);
        for (String s : strs) {
            //  if(s.length()>2)
        }
        return 0;
    }

    private void analysisFromFile() throws IOException {
        Set<String> nameSet = new HashSet<>();
        ObjectMapper om = new ObjectMapper();
        File file = new File(ProjectNameAnalysis.class.getResource("/name.json").getFile());
        nameSet = om.readValue(file, nameSet.getClass());
        NamePattern np = new NamePattern("name");
        nameSet.forEach(s->{
            if(!s.startsWith("小"))
                np.analysisOnce(s);
        });
        np.writeToFile("namePattern.json");
    }

//    public static void main(String[] args) {
//        try {
//            new NameAnalysis().analysisFromFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
//        try {
//            new NameAnalysis().analysisFromFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File file = new File(ProjectNameAnalysis.class.getResource("/namePattern.json").getFile());

        String[] examples = {"南山区","邓彪","李秀英"};
        try {
            NamePattern np = new ObjectMapper().readValue(file, NamePattern.class);

            Map<String, Double> map = np.getWordOccurrence();
            Set<String> oneKey = new HashSet<>();
            for (String s : map.keySet())
                if (map.get(s) <= 1.0)
                    oneKey.add(s);
            for (String s : oneKey)
                map.remove(s);
            for (String s : examples) {
                System.out.println(np.similarity(s) + "  " + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
