package cn.larry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */
@Entity
@Table(name="demoapp_resume_socialexperience")
public class Socialexperience {

    @Id
    private int id;

    private int ResumeList_id;

    @Column(length = 2000)
    private String MainInfo;
    @Column(length = 2000)
    private String MainWork;
    @Column(length = 2000)
    private String Memo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeList_id() {
        return ResumeList_id;
    }

    public void setResumeList_id(int resumeList_id) {
        ResumeList_id = resumeList_id;
    }

    public String getMainInfo() {
        return MainInfo;
    }

    public void setMainInfo(String mainInfo) {
        MainInfo = mainInfo;
    }

    public String getMainWork() {
        return MainWork;
    }

    public void setMainWork(String mainWork) {
        MainWork = mainWork;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }
}
