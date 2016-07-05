package cn.larry.analysis;

import cn.larry.Dao.HibernateDaoUtil;
import cn.larry.entity.Resumelist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created by Thinkpad on 2015/11/18.
 */
public class Analysis {

    public static void main(String[] args) {
        HibernateDaoUtil  hibernateDaoUtil = new HibernateDaoUtil();
        List<Resumelist> resumes = hibernateDaoUtil.find("from "+ Resumelist.class.getName()+" where id =1");
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(resumes));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



}
