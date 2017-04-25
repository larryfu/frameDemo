package cn.larry.demo.solr.feeds;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author larryfu
 */

public class RegexUtils {
    //static final Logger logger = LogManager.getLogger();

    public static final String EMAIL_PTN = "[0-9a-zA-Z._-]+@([-0-9a-zA-Z]{1,22}.)+[-a-zA-Z]{1,22}";

    public static final String ID_PTN = "[1234568][1-7]\\d{15}(\\d|X|x)";

    public static final String PHONE_PTN = "1[3458]\\d{9}";

    public static final String POST_PTN = "^\\d{6}($|\\D)";

    public static final String NAME_PTH = "[\u4e00-\u9fa5]{2,6}";

    public static final String TIME_PTN = "(19|20)\\d{2}(-|/|\\.|年)(0|1)?\\d月?((-|\\.|/)?\\d{1,2}日?)?($|\\D)";

    public static final String SEX_PTN = "男|女";

    public static final String YEARMONTH_RANGE = "(19|20)\\d{2}(-|/|\\.|年)(0|1)?\\d月?-{1,3}(19|20)\\d{2}(-|/|\\.|年)(0|1)?\\d月?";

    public static final String SCALE_PTH = "(少于)?\\d{2,5}人((-\\d{2,5}人)|以上)?";

    public static final String NAME_PTN = "([\u4e00-\u9fa5]|\\w){2,30}";

    public static final String BARKET_PTN = ".(\\(|（)[^(\\)||）)]+(\\)|）)";

    public static final String SALARY_PTN = "\\d{4,5}-\\d{4,5}(元/月)?";

    public static boolean containsPattern(String pattern, String s) {
        return getMatch(pattern, s).size() > 0;
    }

    public static List<String> getMatch(String regex, String content) {
        Matcher matcher = Pattern.compile(regex).matcher(content);
        List<String> result = new ArrayList<>();
        while (matcher.find())
            result.add(matcher.group());
        return result;
    }

    public static String getFirstMatch(String regex, String content) {
        if (regex == null || content == null)
            return null;
        //logger.info("get first match regex:" + regex + ",content:" + content);
        List<String> result = getMatch(regex, content);
        return result.size() == 0 ? null : result.get(0);
    }

    //51job简历时间范围会换行,必须消除换行 如2007 /10--2008
    //                      /10，
    public static String format51jobTime(String resume) {
        String regex = "(19|20)\\d{2}\\s*\\n*/(0|1)?\\d-{1,2}((19|20)\\d{2}\\n\\s*/(0|1)?\\d|至今)";
        Matcher matcher = Pattern.compile(regex).matcher(resume);
        while (matcher.find()) {
            String str = matcher.group();
            String rstr = str.replaceAll("\\s+|\\n", "");
            resume = resume.replaceAll(str, rstr);
        }

        return resume;
    }

}
