package cn.larry.demo.file;


import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by fugz on 2016/8/4.
 */
public class TypeInfo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\6EnterpriseFileExtStatics";
        Gson gson = new Gson();
        List<String> includeExt = Arrays.asList("doc", "TXT", "ppsx", "cvs", "htm", "pcddoc", "pdf", "docm", "docx", "pptx", "PPT", "PDF", "txt", "xlsx", "xlsm", "DOC", "Pdf", "ppt", "pdf", "XLS", "wps", "pptx", "html", "ppt", "XLSX");
        List<String> strings = Files.newBufferedReader(Paths.get(path)).lines().collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        List<Map> infoList = strings.stream().map(s -> gson.fromJson(s, map.getClass())).collect(Collectors.toList());
        infoList = infoList.stream().filter(m -> includeExt.contains(m.get("ext"))).collect(Collectors.toList());
        double totalSize = 0;
        double totalNum = 0;
        for (Map<String, Object> map1 : infoList) {
            totalSize += (Double) map1.get("total");
            totalNum += (Double) map1.get("count");
        }
        double GBSize = totalSize / (1024 * 1024 * 1024);
        System.out.println("total size :" + GBSize + "GB");
        System.out.println("total count :" + totalNum);
        System.out.println("avg size:" + (totalSize / totalNum) / 1024);
        System.out.println(1 << 30);
    }
}
