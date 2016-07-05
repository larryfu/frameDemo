package cn.larry.analysis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Thinkpad on 2015/11/18.
 */
public class AttributePattern {


     String attributeName;

     long total; //解析的attribute 如项目名称 的条数

     long wordtotal;

     Map<String, Double> wordOccurrence = new HashMap<>(); //词出现次数

     int[] lengths;  //属性长度 出现次数

    public AttributePattern(String attributeName) {
        this(attributeName, 1000);
    }

    public AttributePattern(String attributeName, int maxLength) {
        this.attributeName = attributeName;
        this.total = 0;
        this.wordtotal = 0;
        this.wordOccurrence = new HashMap<>();
        lengths = new int[maxLength];
    }

    public void analysisOnce(String str) {
        System.out.println("analysis once:" + str);
        String[] strs = splitElement(str);
        lengths[str.length()] = lengths[str.length()] + 1;
        for (String s : strs)
            add(s);
        this.total++;
        specialAnalysis(strs);
    }

    protected void specialAnalysis(String[] ss){
    }

    protected String[] splitElement(String ele){
       return IKSpliter.splitString(ele);
    }

    private void add(String word) {
        if (wordOccurrence.get(word) == null)
            wordOccurrence.put(word, 0.0);
        wordOccurrence.put(word, wordOccurrence.get(word) + 1);
        wordtotal++;
    }

    @NotNull
    public double getwordRatio(String word) {
        Double d = wordOccurrence.get(word);
        if (d == null) d = 0.0;
        return d / (double) total;
    }

    public Map<String, Double> getWordOccurrence() {
        return wordOccurrence;
    }


    public double getAvgLength() {
        long totalLength = 0;   //字总数
        long attrNumber = 0; //属性总数
        for (int i = 0; i < lengths.length; i++) {
            totalLength += lengths[i] * i;
            attrNumber += lengths[i];
        }
        return (double) totalLength / (double) attrNumber;
    }


    public double getAvgWordNumber() {
        long wordNumber = 0;
        for (String w : wordOccurrence.keySet())
            wordNumber += wordOccurrence.get(w);
        return (double) wordNumber / (double) total;
    }

    /**
     * 计算长度为len的在总体中数量与平均长度之比
     *
     * @param len
     * @return
     */
    public double getWeight(int len) {
        long attr = 0;  //长度项数量
        long total = 0;   // 总长度
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > 1) {  //忽略出现次数在1次及以下的项
                attr++;
                total += lengths[i];
            }
        }
        double avg = (double) total / (double) attr; //平均长度
        return Math.sqrt((double) lengths[len] / avg);
    }


    private void remove(String word) {
        Double num = wordOccurrence.get(word);
        if (num != null) {
            wordOccurrence.remove(word);
            total -= num;
        }
    }

    public void removeOnlyOneElements() {
        Set<String> onlyOnceWords = new HashSet<>();
        wordOccurrence.forEach((k, v) -> {
            if (v <= 1.0)
                onlyOnceWords.add(k);
        });
        onlyOnceWords.forEach(this::remove);
    }

    /**
     * 计算字符串 str 与本模式的相似度
     *
     * @param str
     * @return
     */
    private double similarity(String str) {
        return similarity(str, 2);
    }

    public double similarity(String str, int lastAddition) {
        int len = str.length();
        analysisOnce(str);
        String[] strs = splitElement(str);

        double sim = 0;
        for (String s : strs)
            sim += getwordRatio(s);

        //加大最后一个词的权重
        String lastWord = strs[strs.length - 1];
        sim += lastAddition * getwordRatio(lastWord);

        return (sim / (double) strs.length) * getWeight(len);
    }

    public void writeToFile( String relativePath)  {
        try {
            String str = new ObjectMapper().writeValueAsString(this);
            File file = new File(this.getClass().getResource("/").getFile()+"/"+relativePath);
            FileUtils.write(file, str, StandardCharsets.UTF_8);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAvgLength(double length) {

    }

    public void setAvgWordNumber(double num) {
    }

    public void setlength(int[] lengths) {
        this.lengths = lengths;
    }

    public int[] getLengths() {
        return lengths;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }


    public long getTotal() {
        return total;
    }

    public long getWordtotal() {
        return wordtotal;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setWordtotal(long wordtotal) {
        this.wordtotal = wordtotal;
    }

    public void setWordOccurrence(Map<String, Double> wordOccurrence) {
        this.wordOccurrence = wordOccurrence;
    }

    public void setLengths(int[] lengths) {
        this.lengths = lengths;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public AttributePattern() {
        lengths = new int[2000];
    }

}
