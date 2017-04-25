package cn.larry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Thinkpad on 2015/12/7.
 */
public class ClimbName {

    private static final String START_PAGE = "http://www.ganji.com/findjob/resume_list.php";

    private List<String> names;

    static Logger logger = LogManager.getLogger();

    public ClimbName() {
        names = new LinkedList<>();
    }

    private Set<String> extractName(String url) {
        Set<String> ss = new HashSet<>();
        Document doc ;
        System.out.println("get name from  page : "+url);
        try {
            doc = Jsoup.parse(new URL(url), 3000);
        } catch (IOException e) {
            e.printStackTrace();
            return ss;
        }
        Elements as = doc.select("a");
        for (Element e : as) {
            String href = e.attr("href");
            if (href.contains(".ganji.com/jianli/")) {
                String name = e.text();
                if (validName(name))
                    ss.add(name);
            }
        }
        return ss;
    }

    private boolean validName(String name) {
        return name.matches("[\u4e00-\u9fa5]+") && !name.matches(".*(先生|会计(师)?|小姐|师傅|女士|主任|设计)$");
    }


    public static void main(String[] args) throws JsonProcessingException {

        Integer[] indexs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 353, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386};
        ClimbName cn = new ClimbName();
        for (int i : indexs)
            cn.collectNames(i);
        System.out.println(new ObjectMapper().writeValueAsString(cn.names));
    }

    public void collectNames(int index) {
       // HttpAgent ha = new HttpAgent();
      //  Set<String> prevSet = new HashSet<>();
        logger.info("start");
        Set<String> ss = new HashSet<>();
        for (int i = 0; i <= 992; i += 32) {
            String url = START_PAGE + "?city=" + index + "&page=" + i;
           // String page = ha.getPage(url);
            Set<String> current = extractName(url);
            ss.addAll(current);
//            int equlasNum = getEqualELeNum(prevSet, current);
//            if (equlasNum > current.size() * 0.8) {
//                System.out.println("name duplicate， break loop city:" + index + " i=" + i);
//                break;
//            }
  //          prevSet = current;
        }
        names.addAll(ss);
        ObjectMapper om = new ObjectMapper();
        try {
            System.out.println(om.writeValueAsString(names));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info("end");
    }

    private int getEqualELeNum(Set<String> prevSet, Set<String> current) {
        int num = 0;
        for (String s : prevSet)
            if (current.contains(s))
                num++;
        return num;
    }
}
