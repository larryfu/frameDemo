package cn.larry.demo.tika;

import java.io.InputStream;

/**
 * Created by fugz on 2016/8/1.
 */
public interface DocumentParser {

    String parse(InputStream inputStream);
}
