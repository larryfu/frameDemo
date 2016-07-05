package cn.larry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */
@Entity
@Table(name="demoapp_resume_trains")
public class Trains {

    @Id
    private int id;

    private int ResumeList_id;

    private String MainInfo;
    private String TrainSchool;
    private String TrainZizhi;
    private String Trainzhengshu;
    @Column(length = 2000)
    private String TrainMemo;

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

    public String getTrainSchool() {
        return TrainSchool;
    }

    public void setTrainSchool(String trainSchool) {
        TrainSchool = trainSchool;
    }

    public String getTrainZizhi() {
        return TrainZizhi;
    }

    public void setTrainZizhi(String trainZizhi) {
        TrainZizhi = trainZizhi;
    }

    public String getTrainzhengshu() {
        return Trainzhengshu;
    }

    public void setTrainzhengshu(String trainzhengshu) {
        Trainzhengshu = trainzhengshu;
    }

    public String getTrainMemo() {
        return TrainMemo;
    }

    public void setTrainMemo(String trainMemo) {
        TrainMemo = trainMemo;
    }
}
