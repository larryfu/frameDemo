package cn.larry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */
@Entity
@Table(name="demoapp_resume_workexperiences")
public class Workexperiences {

    @Id
    private int id;

    private int ResumeList_id;

    @Column(length = 1000)
    private String MainInfo;
    private String Hangye;
    private String Department;
    private String Position;
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

    public String getHangye() {
        return Hangye;
    }

    public void setHangye(String hangye) {
        Hangye = hangye;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }
}
