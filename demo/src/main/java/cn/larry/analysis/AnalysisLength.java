package cn.larry.analysis;

import cn.larry.Dao.HibernateDaoUtil;
import cn.larry.entity.Projects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thinkpad on 2015/11/18.
 */
public class AnalysisLength {

    public static void main(String[] args) {
        HibernateDaoUtil hdl = new HibernateDaoUtil();
        System.out.println("startTime:" + LocalTime.now());
        List<Object> lens = hdl.find("select count(id) from " + Projects.class.getName());
        long len = (Long) lens.get(0);
        //len = 1000;
        int step = 5000;
        Integer[] numbers = new Integer[200];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=0;
         for (int i = 0; i < len; i += step) {

            List<Projects> projects = hdl.pageSearch(Projects.class, i,  step);
           // System.out.println(projects.size());
            projects.stream().forEach((p) -> {
                String[] mainInfo = p.getMainInfo().split("：");

                if (mainInfo.length > 0)
                    numbers[mainInfo[mainInfo.length - 1].length()]++;
                //System.out.print(mainInfo[mainInfo.length - 1].length() + " ");
            });

        }
        long total = 0;
        long number = 0;
        for(int i = 0;i<numbers.length;i++){
            total += (long)i*numbers[i];
            number += numbers[i];
        }
        double avg = ((double)total)/(double)number;
        System.out.println("total:"+total+",number:"+number+"avg length "+avg);
        System.out.println(Arrays.asList(numbers));
        System.out.println("endTime:" + LocalTime.now());
        hdl.getSessionFactory().close();

//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(projects));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }



}
