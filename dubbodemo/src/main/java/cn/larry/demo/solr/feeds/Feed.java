package cn.larry.demo.solr.feeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by fugz on 2016/4/14.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

    public long EI;

    public long FeedId;

    public int Type;

    public long Creator;

    public String CreatedDate;

    public String Content;

    public List<Long> Participators;
//
//    public int getEI() {
//        return EI;
//    }
//
//    public void setEI(int EI) {
//        this.EI = EI;
//    }
//
//    public long getFeedId() {
//        return FeedId;
//    }
//
//    public void setFeedId(long feedId) {
//        FeedId = feedId;
//    }
//
//    public int getType() {
//        return Type;
//    }
//
//    public void setType(int type) {
//        Type = type;
//    }
//
//    public int getCreator() {
//        return Creator;
//    }
//
//    public void setCreator(int creator) {
//        Creator = creator;
//    }
//
//    public String getCreatedDate() {
//        return CreatedDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        CreatedDate = createdDate;
//    }
//
//    public String getContent() {
//        return Content;
//    }
//
//    public void setContent(String content) {
//        Content = content;
//    }


}
