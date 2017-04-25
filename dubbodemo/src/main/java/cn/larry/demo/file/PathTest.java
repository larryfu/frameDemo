package cn.larry.demo.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fugz on 2016/4/26.
 */
public class PathTest {
    public static void main(String[] args) throws IOException {
        String pathStr = "D:\\data.txt";
        List<String> lines = new ArrayList<>();
        lines.add("this is a test");
        lines.add("another line");
        Path path = Paths.get(pathStr);
        if (!Files.exists(path))
            Files.createFile(path);
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
