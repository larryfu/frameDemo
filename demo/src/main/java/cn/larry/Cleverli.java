package cn.larry;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dengshougang on 16/7/22.
 */

class Gt {
    int success;
    String gt;
    String challenge;
}


public class Cleverli {

    private static final Logger log = LogManager.getLogger();

    static final String cleverliUrl = "http://dev.cleverli.cn:8310/api/captcha/geetest";

    static final String qichachaUrl = "http://www.qichacha.com";

    static WebClient WEB_CLIENT;

    static final String appid = "34440900";

    static final String appkey = "asD2dloR31Dqppc3";

    public static String getLogInUrl() {
        return qichachaUrl + "/user_login";
    }

    public static String getGtUrl() {
        String res = qichachaUrl + "/index_getcap?rand=" + String.valueOf((int) (Math.random() * 10));
        log.info("gt url = {}", res);
        return res;
    }

    static {
        System.getProperties().setProperty("webdriver.chrome.driver",
                "/Users/dengshougang/Workspaces/Tools/driver/chromedriver");
    }


    public static Map getQccLogInfo(String url) throws IOException, InterruptedException {

        String html;
//        html = getLogInHtml(url);
//        Pattern pattern=Pattern.compile("script charset=(.*?) src=(.*?)></script>");
//        Matcher matcher=pattern.matcher(html);
//        if (matcher.find());
        String result;
//        result = (matcher.group(0));
        result = getGtInfo();
        result = StringUtils.remove(result, "&amp");
        log.info("regex result:{}", result);
        Map<String, String> params = new HashMap<String, String>();

        params.put("gt", result.substring(result.indexOf("gt") + 5, result.indexOf("challenge") - 3));
        params.put("challenge", result.substring(result.indexOf("challenge") + 12, result.indexOf("\"}")));
//        params.put("product","");
        params.put("referer", url);
        params.put("appid", appid);
        Document doc = Jsoup.connect(qichachaUrl).get();
        log.info("connect qichacha {}", doc.outerHtml());
        return params;
    }


    public static String getGtInfo() throws IOException {
        Connection con = Jsoup.connect(getLogInUrl());
        Connection.Response res = con.execute();
        Document doc2 = Jsoup.connect(getGtUrl()).cookies(res.cookies()).get();
        log.info("response:{}", doc2.outerHtml());
        return doc2.outerHtml();
    }

    public static String getSignInfo(Map map) {
        TreeMap treeMap = new TreeMap(map);
        String url = "";
        for (Object obj : treeMap.entrySet()) {
            Iterator it = treeMap.entrySet().iterator();
            it.hasNext();
            Map.Entry entry = (Map.Entry) obj;
            Object k = entry.getKey();
            Object v = entry.getValue();
            if ((null != v) && !"key".equals(k) && !"signinfo".equals(k)) {
                url += k + "=" + v + "&";
            }
        }
        log.info("url:{}", url + appkey);
        String signInfo = "";
        try {
            signInfo = DigestUtils.md5Hex((url + appkey).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("{}", e);
        }
        String result = cleverliUrl + "?" + url + "signinfo=" + signInfo;
        log.info("result:{}", result);
        return result;
    }

    public static void test() throws IOException, InterruptedException {
        Map map = getQccLogInfo(getLogInUrl());
        log.info("data map:{}", map.toString());
        String signInfo = getSignInfo(map);
        String accessUrl = signInfo;

        log.info("accessUrl:{}", accessUrl);

        Document doc = Jsoup.connect(accessUrl).data(map).timeout(50000).get();
        log.info("\ncleverli result:{}", doc.outerHtml());
    }


    public static String getLogInHtml(String url) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        String str = (webElement.getAttribute("outerHTML"));
        webDriver.close();
        return str;
    }

    public static void webClientInit() throws GeneralSecurityException {
        WEB_CLIENT = new WebClient(BrowserVersion.CHROME);
        WEB_CLIENT.getOptions().setUseInsecureSSL(true);
        WEB_CLIENT.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
//        WEB_CLIENT.setAjaxController(new NicelyResynChronizingAjaxController());
        WEB_CLIENT.getOptions().setCssEnabled(false); // 禁用css支持
        WEB_CLIENT.getOptions().setThrowExceptionOnFailingStatusCode(false);
        WEB_CLIENT.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
//        WEB_CLIENT.getOptions().setT
        WEB_CLIENT.getOptions().setTimeout(2000); // 设置连接超时时间 ，这里是2S。如果为0，则无限期等待
        WEB_CLIENT.getOptions().setDoNotTrackEnabled(false);
    }

    public void postImageTest() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/dengshougang/Downloads/VerifyImages/ShenzhenCredit/download/5.png");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8088/capcha/shenzhencredict");
        FileBody img = new FileBody(new File("/Users/dengshougang/Downloads/VerifyImages/ShenzhenCredit/download/6.png"));
        HttpEntity reqEntity = MultipartEntityBuilder.create()
//                .addPart("image", img)
                .build();
        post.setEntity(reqEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        log.info("response:{}", IOUtils.readLines(response.getEntity().getContent()));
        log.info("response:{}", IOUtils.toString(response.getEntity().getContent()));

    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
