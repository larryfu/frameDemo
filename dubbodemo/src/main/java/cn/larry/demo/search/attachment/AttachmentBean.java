package cn.larry.demo.search.attachment;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * Created by fugz on 2016/4/20.
 */
public class AttachmentBean {

    @Field
    private String id;  //经过转换的附件id同时也是doc id

    @Field
    private String fileName; //附件名

    @Field
    private Date createTime; //附件上传时间

    @Field
    private String participators; //附件的可见范围

    @Field
    private String senderId; //附件上传者id


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getParticipators() {
        return participators;
    }

    public void setParticipators(String participators) {
        this.participators = participators;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

}
