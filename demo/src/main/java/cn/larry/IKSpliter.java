package cn.larry;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 *
 * @author larryfu  all rights reserved
 */
public class IKSpliter {

    static Logger logger = LogManager.getLogger();
    //  private static


    public static void main(String[] args) {
        System.out.println(Arrays.asList(splitString("纷享逍客公司")));
    }

    public static String[] splitString(String newstext) {
        try {

            logger.info("split start " + newstext);
            List<String> wordsList = new ArrayList<>();
            StringReader reader = new StringReader(newstext);
            //分词
            Analyzer anal = new IKAnalyzer(false);
            TokenStream ts = anal.tokenStream("", reader);
            ts.reset();
            CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
            //遍历分词数据
            while (ts.incrementToken())
                wordsList.add(term.toString());
            String[] strs = new String[wordsList.size()];
            for (int i = 0; i < wordsList.size(); i++)
                strs[i] = wordsList.get(i);
            logger.info("split finish ");
            return strs;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
