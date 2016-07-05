package cn.larry.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Thinkpad on 2015/11/17.
 */

@Entity
@Table(name="demoapp_resumelist")
public class Resumelist {
    @Id
    private int id;

    private String Fromsite;
    private String Code;
    private String Name;
    private String Resumeurl;
    private String Age;
    private String Workexperience;
    private String Sex;
    private String Lifecity;
    private String Major;
    private String Education;
    private String Graduateschool;
    private String Lastrefreshdate;
    private String Createdate;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<BaseInfo> baseInfo;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Certificates> certificates;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Educations> educations;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Evaluations> evaluations;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<ITskill> iTskills;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Languages> languages;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Otherinfo> otherinfo;

    @OneToMany(mappedBy = "ResumeList_id" ,fetch=FetchType.EAGER)
    private List<Projects> projectses;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Rewards> rewardses;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Schooloffice> schooloffices;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Socialexperience> socialexperiences;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Trains> trainses;

    @OneToMany(mappedBy = "ResumeList_id",fetch=FetchType.EAGER)
    private List<Workexperiences> workexperiences;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromsite() {
        return Fromsite;
    }

    public void setFromsite(String fromsite) {
        Fromsite = fromsite;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getResumeurl() {
        return Resumeurl;
    }

    public void setResumeurl(String resumeurl) {
        Resumeurl = resumeurl;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getWorkexperience() {
        return Workexperience;
    }

    public void setWorkexperience(String workexperience) {
        Workexperience = workexperience;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getLifecity() {
        return Lifecity;
    }

    public void setLifecity(String lifecity) {
        Lifecity = lifecity;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getGraduateschool() {
        return Graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        Graduateschool = graduateschool;
    }

    public String getLastrefreshdate() {
        return Lastrefreshdate;
    }

    public void setLastrefreshdate(String lastrefreshdate) {
        Lastrefreshdate = lastrefreshdate;
    }

    public String getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(String createdate) {
        Createdate = createdate;
    }



    public List<Certificates> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificates> certificates) {
        this.certificates = certificates;
    }

    public List<Educations> getEducations() {
        return educations;
    }

    public void setEducations(List<Educations> educations) {
        this.educations = educations;
    }



    public List<ITskill> getiTskills() {
        return iTskills;
    }

    public void setiTskills(List<ITskill> iTskills) {
        this.iTskills = iTskills;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<BaseInfo> getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(List<BaseInfo> baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<Evaluations> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluations> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Otherinfo> getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(List<Otherinfo> otherinfo) {
        this.otherinfo = otherinfo;
    }

    public List<Projects> getProjectses() {
        return projectses;
    }

    public void setProjectses(List<Projects> projectses) {
        this.projectses = projectses;
    }

    public List<Rewards> getRewardses() {
        return rewardses;
    }

    public void setRewardses(List<Rewards> rewardses) {
        this.rewardses = rewardses;
    }

    public List<Schooloffice> getSchooloffices() {
        return schooloffices;
    }

    public void setSchooloffices(List<Schooloffice> schooloffices) {
        this.schooloffices = schooloffices;
    }

    public List<Socialexperience> getSocialexperiences() {
        return socialexperiences;
    }

    public void setSocialexperiences(List<Socialexperience> socialexperiences) {
        this.socialexperiences = socialexperiences;
    }

    public List<Trains> getTrainses() {
        return trainses;
    }

    public void setTrainses(List<Trains> trainses) {
        this.trainses = trainses;
    }

    public List<Workexperiences> getWorkexperiences() {
        return workexperiences;
    }

    public void setWorkexperiences(List<Workexperiences> workexperiences) {
        this.workexperiences = workexperiences;
    }
}
