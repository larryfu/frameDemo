package cn.larry.demo.solr.feeds;

import org.apache.solr.client.solrj.beans.Field;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by fugz on 2016/4/14.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedBean {

    /**
     * Solr server的对应Field
     *
     * @author harryzheng 2015-11-23
     */

    @Field
    private String id;  //doc id

    @Field
    private String feedContent; //feeds type

    @Field
    private Date createdDate; //feeds creatorDate

    @Field
    private String participators; //feeds @userid

    @Field
    private String creator; //feeds creator

    @Field
    private String feedType; //feeds type

    public FeedBean(Feed feed) {
        this.id = feed.EI + "";
        this.feedContent = feed.Content;
        this.createdDate = TimeUtils.parseDate(feed.CreatedDate);
        this.participators = feed.Participators.toString();
        this.feedType = feed.Type + "";
        this.creator = feed.Creator + "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }

    public String getFeedContent() {
        return feedContent;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setParticipators(String participators) {
        this.participators = participators;
    }

    public String getParticipators() {
        return participators;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getFeedType() {
        return feedType;
    }
}

