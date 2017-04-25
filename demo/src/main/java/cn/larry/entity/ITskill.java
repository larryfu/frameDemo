package cn.larry.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */
@Entity
@Table(name="demoapp_resume_itskill")
public class ITskill {
    @Id
    private int id;

    private int ResumeList_id;

    private String MainInfo;
    private String Proficiency;
    private String UseOfTime;

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

    public String getProficiency() {
        return Proficiency;
    }

    public void setProficiency(String proficiency) {
        Proficiency = proficiency;
    }

    public String getUseOfTime() {
        return UseOfTime;
    }

    public void setUseOfTime(String useOfTime) {
        UseOfTime = useOfTime;
    }
}
