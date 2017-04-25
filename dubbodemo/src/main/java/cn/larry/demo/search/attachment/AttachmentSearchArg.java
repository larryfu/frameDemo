package cn.larry.demo.search.attachment;

import com.dyuproject.protostuff.Tag;
import com.facishare.common.fsi.ProtoBase;

import java.util.ArrayList;

/**
 * Created by fugz on 2016/4/21.
 */
public class AttachmentSearchArg extends ProtoBase {

    @Tag(10)
    private String traceId;

    @Tag(11)
    private long EI;

    @Tag(12)
    private long userId;

    @Tag(13)
    private String keyword;

    @Tag(14)
    private ArrayList<Long> creators;

    @Tag(15)
    private String startDate;

    @Tag(16)
    private String endDate;

    @Tag(17)
    private int startRow;

    @Tag(19)
    private int returnRows;

}
