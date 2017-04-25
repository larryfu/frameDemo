package cn.larry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        int i  = Integer.MAX_VALUE;
        i = i+1;
        int j = Integer.MIN_VALUE;
        j --;

        System.out.println(i);
        System.out.println(j);
//        Pattern p = Pattern.compile("(\\d)(.)\\2+");
//        Matcher m = p.matcher("1213122");
//        while (m.find()){
//            System.out.println(m.group());
//        }
    }
}
