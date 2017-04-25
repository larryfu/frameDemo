package cn.larry.demo.solr.feeds;


import java.util.List;

/**
 * 从feeds数据库中导出的数据文件，格式如下：
 * {"Ei":17,"FeedId":398821,"Type":2003,"Creator":3253,"CreatedDate":"2015-11-10T14:41:28.137","Content":"Jsjdjsj","Participators":[2,3179,3180,3253,3483]}
 * @author harryzheng 2015-11-23
 *
 */
public class DataBean {
    private long EI; //公司账号

    private long FeedId;  //feed id，公司内部唯一

    private int Type;  //feed类型

    private int Creator;  //feed发表者

    private String CreatedDate;  //feed发表时间

    private String Content;  //feed内容

    private List<Long> Participators; //feed可见列表

    public void setEI(long EI){
        this.EI = EI;
    }

    public long getEI(){
        return this.EI;
    }

    public void setFeedId(long FeedId){
        this.FeedId = FeedId;
    }

    public long getFeedId(){
        return this.FeedId;
    }

    public void setType(int type){
        this.Type = type;
    }

    public int getType(){
        return this.Type;
    }

    public void setCreator(int Creator){
        this.Creator = Creator;
    }

    public int getCreator(){
        return this.Creator;
    }

    public void setCreatedDate(String CreatedDate){
        this.CreatedDate = CreatedDate;
    }

    public String getCreatedDate(){
        return this.CreatedDate;
    }

    public void setContent(String Content){
        this.Content = Content;
    }

    public String getContent(){
        return this.Content;
    }

    public void setParticipators(List<Long> Participators){
        this.Participators = Participators;
    }

    public List<Long> getParticipators(){
        return this.Participators;
    }
}

