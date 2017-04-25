package cn.larry.demo.lucene;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;


/**
 * Created by Thinkpad on 2015/11/18.
 *
 * @author larryfu  all rights reserved
 */
public class IKSpliter {

    static Logger logger = LogManager.getLogger(IKSpliter.class);

    public static void main(String[] args) throws IOException {
        System.out.println(analyzeWithIK("阿狸-LOVE.ssf"));
        Set<String> sets = new TreeSet<>();
//        sets.add(null);
    }


    public static List<String> analyzeWithIK(String text) throws IOException {
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotBlank(text)) {
            IKSegmenter ik = new IKSegmenter(new StringReader(text), false);
            Lexeme lexeme;
            while ((lexeme = ik.next()) != null)
                list.add(lexeme.getLexemeText());
        }
        return list;
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
            //  logger.info("split finish ");
            return strs;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
