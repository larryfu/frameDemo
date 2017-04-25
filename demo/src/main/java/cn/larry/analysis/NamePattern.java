package cn.larry.analysis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thinkpad on 2015/12/7.
 */
public class NamePattern extends AttributePattern {



    private Map<String, Integer> firstNameMap;

    public NamePattern(String name) {
        super(name, 10);
        firstNameMap = new HashMap<>();
    }

    public NamePattern() {
        super();
        firstNameMap = new HashMap<>();
    }

    @Override
    public void specialAnalysis(String[] ss) {
        if (ss.length == 0) return;
        String firstName = ss[0];
        if (firstNameMap.get(firstName) == null)
            firstNameMap.put(firstName, 0);
        firstNameMap.put(firstName, firstNameMap.get(firstName) + 1);
    }


    @Override
    public String[] splitElement(String ele) {
        char[] cs = ele.toCharArray();
        String[] ss = new String[cs.length];
        for (int i = 0; i < cs.length; i++)
            ss[i] = cs[i] + "";
        return ss;
    }

    public Double getFirstNameWeight(String fn){
        Integer d = firstNameMap.get(fn);
        if (d == null) d = 0;
        return d / (double) total;
    }

    public double similarity(String str) {
        int len = str.length();
        analysisOnce(str);
        String[] strs = splitElement(str);

        double sim = 0;
        for (String s : strs)
            sim += getwordRatio(s);

        sim += 3*getFirstNameWeight(strs[0]);

        return (sim / (double) strs.length) * getWeight(len);
    }

    public Map<String, Integer> getFirstNameMap() {
        return firstNameMap;
    }

    public void setFirstNameMap(Map<String, Integer> firstNameMap) {
        this.firstNameMap = firstNameMap;
    }

}
