package cn.larry.demo.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by fugz on 2016/4/21.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        TestItem item = new TestItem();
    //    item.setBithday(new Date());
      //  item.setId(11);
        item.setName("larry");
        item.setJob("programer");
        byte[] bytes = item.toProto();
        Files.write(Paths.get("d:\\protodata.data"),bytes, StandardOpenOption.CREATE);
    }
}
