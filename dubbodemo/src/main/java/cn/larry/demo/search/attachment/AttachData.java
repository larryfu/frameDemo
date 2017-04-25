package cn.larry.demo.search.attachment;

import java.util.List;

/**
 * Created by fugz on 2016/4/21.
 */
public class AttachData {
    private long EI; //公司账号

    private long AttachId; //附件Id

    private long SenderId;  //附件上传人

    private String CreateTime;  //上传时间 格式 yyyy-MM-dd HH:mm:ss  e.g 2015-11-10 14:41:28

    private String AttachName;  //附件名

    private List<Long> Participators; //附件可见列表，可见人的id列表


    public long getEI() {
        return EI;
    }

    public void setEI(long EI) {
        this.EI = EI;
    }

    public long getAttachId() {
        return AttachId;
    }

    public void setAttachId(long attachId) {
        AttachId = attachId;
    }

    public long getSenderId() {
        return SenderId;
    }

    public void setSenderId(long senderId) {
        SenderId = senderId;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getAttachName() {
        return AttachName;
    }

    public void setAttachName(String attachName) {
        AttachName = attachName;
    }

    public List<Long> getParticipators() {
        return Participators;
    }

    public void setParticipators(List<Long> participators) {
        Participators = participators;
    }


}
