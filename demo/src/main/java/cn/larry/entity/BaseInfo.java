package cn.larry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thinkpad on 2015/11/17.
 */

@Entity
@Table(name="demoapp_resume_base_info")
public class BaseInfo {

    @Id
    private int id;

    private int ResumeList_id;

    private String Fromsite;
    private String IsLibrary;
    private String NowCanDownloadCount;
    private String ResumeType;
    private String ResumeLastRefreshDate;
    private String Name;
    private String Tag;
    private String WorkExperience;
    private String Sex;
    private String Birthday;
    private String MaritalStatus;
    private String Height;
    private String PoliticalAffiliation;
    private String Title;
    private String Juzhudi;
    private String Hukou;
    private String ZuigaoZhuanye;
    private String ZuigaoXueli;
    private String ZhuyaoZhineng;
    private String ZhuyaoHangye;
    private String Phone;
    private String Email;
    private String LastWorkCompany;
    private String LastWorkHangye;
    private String LastWorkPosition;
    private String HighestXueli;
    private String HighestSchool;
    private String HighestZhuanye;
    private String NowNianxin;
    private String NowJibengongzi;
    private String NowJiangjin;
    private String NowJingtie;
    @Column(length = 2000)
    private String SelfEvaluation;
    private String HopeDaogangshijian;
    private String HopeGongzuoxinzhi;
    private String HopeHangye;
    private String HopePlace;
    private String HopeYuexin;
    private String HopeZhineng;
    private String OfferStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeList_id() {
        return ResumeList_id;
    }

    public String getIsLibrary() {
        return IsLibrary;
    }

    public void setIsLibrary(String isLibrary) {
        IsLibrary = isLibrary;
    }

    public String getNowCanDownloadCount() {
        return NowCanDownloadCount;
    }

    public void setNowCanDownloadCount(String nowCanDownloadCount) {
        NowCanDownloadCount = nowCanDownloadCount;
    }

    public String getResumeType() {
        return ResumeType;
    }

    public void setResumeType(String resumeType) {
        ResumeType = resumeType;
    }

    public String getResumeLastRefreshDate() {
        return ResumeLastRefreshDate;
    }

    public void setResumeLastRefreshDate(String resumeLastRefreshDate) {
        ResumeLastRefreshDate = resumeLastRefreshDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getPoliticalAffiliation() {
        return PoliticalAffiliation;
    }

    public void setPoliticalAffiliation(String politicalAffiliation) {
        PoliticalAffiliation = politicalAffiliation;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getJuzhudi() {
        return Juzhudi;
    }

    public void setJuzhudi(String juzhudi) {
        Juzhudi = juzhudi;
    }

    public String getHukou() {
        return Hukou;
    }

    public void setHukou(String hukou) {
        Hukou = hukou;
    }

    public String getZuigaoZhuanye() {
        return ZuigaoZhuanye;
    }

    public void setZuigaoZhuanye(String zuigaoZhuanye) {
        ZuigaoZhuanye = zuigaoZhuanye;
    }

    public String getZuigaoXueli() {
        return ZuigaoXueli;
    }

    public void setZuigaoXueli(String zuigaoXueli) {
        ZuigaoXueli = zuigaoXueli;
    }

    public String getZhuyaoZhineng() {
        return ZhuyaoZhineng;
    }

    public void setZhuyaoZhineng(String zhuyaoZhineng) {
        ZhuyaoZhineng = zhuyaoZhineng;
    }

    public String getZhuyaoHangye() {
        return ZhuyaoHangye;
    }

    public void setZhuyaoHangye(String zhuyaoHangye) {
        ZhuyaoHangye = zhuyaoHangye;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLastWorkCompany() {
        return LastWorkCompany;
    }

    public void setLastWorkCompany(String lastWorkCompany) {
        LastWorkCompany = lastWorkCompany;
    }

    public String getLastWorkHangye() {
        return LastWorkHangye;
    }

    public void setLastWorkHangye(String lastWorkHangye) {
        LastWorkHangye = lastWorkHangye;
    }

    public String getLastWorkPosition() {
        return LastWorkPosition;
    }

    public void setLastWorkPosition(String lastWorkPosition) {
        LastWorkPosition = lastWorkPosition;
    }

    public String getHighestXueli() {
        return HighestXueli;
    }

    public void setHighestXueli(String highestXueli) {
        HighestXueli = highestXueli;
    }

    public String getHighestSchool() {
        return HighestSchool;
    }

    public void setHighestSchool(String highestSchool) {
        HighestSchool = highestSchool;
    }

    public String getHighestZhuanye() {
        return HighestZhuanye;
    }

    public void setHighestZhuanye(String highestZhuanye) {
        HighestZhuanye = highestZhuanye;
    }

    public String getNowNianxin() {
        return NowNianxin;
    }

    public void setNowNianxin(String nowNianxin) {
        NowNianxin = nowNianxin;
    }

    public String getNowJibengongzi() {
        return NowJibengongzi;
    }

    public void setNowJibengongzi(String nowJibengongzi) {
        NowJibengongzi = nowJibengongzi;
    }

    public String getNowJiangjin() {
        return NowJiangjin;
    }

    public void setNowJiangjin(String nowJiangjin) {
        NowJiangjin = nowJiangjin;
    }

    public String getNowJingtie() {
        return NowJingtie;
    }

    public void setNowJingtie(String nowJingtie) {
        NowJingtie = nowJingtie;
    }

    public String getSelfEvaluation() {
        return SelfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        SelfEvaluation = selfEvaluation;
    }

    public String getHopeDaogangshijian() {
        return HopeDaogangshijian;
    }

    public void setHopeDaogangshijian(String hopeDaogangshijian) {
        HopeDaogangshijian = hopeDaogangshijian;
    }

    public String getHopeGongzuoxinzhi() {
        return HopeGongzuoxinzhi;
    }

    public void setHopeGongzuoxinzhi(String hopeGongzuoxinzhi) {
        HopeGongzuoxinzhi = hopeGongzuoxinzhi;
    }

    public String getHopeHangye() {
        return HopeHangye;
    }

    public void setHopeHangye(String hopeHangye) {
        HopeHangye = hopeHangye;
    }

    public String getHopePlace() {
        return HopePlace;
    }

    public void setHopePlace(String hopePlace) {
        HopePlace = hopePlace;
    }

    public String getHopeYuexin() {
        return HopeYuexin;
    }

    public void setHopeYuexin(String hopeYuexin) {
        HopeYuexin = hopeYuexin;
    }

    public String getHopeZhineng() {
        return HopeZhineng;
    }

    public void setHopeZhineng(String hopeZhineng) {
        HopeZhineng = hopeZhineng;
    }

    public String getOfferStatus() {
        return OfferStatus;
    }

    public void setOfferStatus(String offerStatus) {
        OfferStatus = offerStatus;
    }

    public void setResumeList_id(int resumeList_id) {
        ResumeList_id = resumeList_id;
    }

    public String getFromsite() {
        return Fromsite;
    }

    public void setFromsite(String fromsite) {
        Fromsite = fromsite;
    }
}
