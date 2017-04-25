package cn.larry.demo.file;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;



/**
 * Created by fugz on 2016/4/25.
 */
public class ReadFromFile {

    public static void main(String[] args) throws IOException {
        String dir = "D:\\home\\testData\\";
        long start = System.nanoTime();
        File file = new File(dir);
        File[] files = file.listFiles();
        for (File fl : files) {
            byte[] bytes = Files.readAllBytes(file.toPath());
        }
        long cost = System.nanoTime() - start;
        System.out.println("read dir" + dir + " ,cost time:" + cost);
    }

}
