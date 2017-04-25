package cn.larry.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thinkpad on 2015/11/18.
 */
public class IKSpliter {

    public static String[] splitString(String newstext){
        try {
            List<String> wordsList =new ArrayList<>();
            Analyzer anal=new IKAnalyzer(false);
            StringReader reader=new StringReader(newstext);
            //分词
            TokenStream ts = anal.tokenStream("", reader);

            ts.reset();
            CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
            //遍历分词数据
            while(ts.incrementToken()){
                wordsList.add(term.toString());
                //System.out.print(term.toString()+"|");
            }
            String[] strs = new String[wordsList.size()];
            for(int i = 0;i<wordsList.size();i++)
                strs[i] = wordsList.get(i);
            return strs;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(splitString("西安信托业务综合管理信息系统")));
    }
}
