package cn.larry.demo.search.attachment;

import com.dyuproject.protostuff.Tag;
import com.facishare.common.fsi.ProtoBase;

import java.util.ArrayList;

/**
 * Created by fugz on 2016/4/21.
 */
public class AttachmentSearchResult extends ProtoBase {

    /** Status code */
    @Tag(10)
    private int statusCode;

    /** Status message */
    @Tag(11)
    private String statusMsg = "OK";

    /** hit count*/
    @Tag(12)
    private long totalCount;

    /** query words */
    @Tag(13)
    private String segmentatedQuery;

    /** FeedIds */
    @Tag(14)
    private ArrayList<Long> attachIds;
}
