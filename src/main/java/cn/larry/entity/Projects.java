package cn.larry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */
@Entity
@Table(name="demoapp_resume_projects")
public class Projects {
    @Id
    private int id;

    private int ResumeList_id;

    @Column(length = 2000)
    private String MainInfo;
    @Column(length = 3000)
    private String ProjectInfo;
    @Column(length = 3000)
    private String Porject_ZeRen;

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

    public String getProjectInfo() {
        return ProjectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        ProjectInfo = projectInfo;
    }

    public String getPorject_ZeRen() {
        return Porject_ZeRen;
    }

    public void setPorject_ZeRen(String porject_ZeRen) {
        Porject_ZeRen = porject_ZeRen;
    }
}
