package cn.larry.demo.protobuf;

import com.facishare.common.fsi.ProtoBase;

import java.util.Date;

/**
 * Created by fugz on 2016/4/21.
 */
public class TestItem extends ProtoBase  {

  //  private int id;
    private String name;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String job;

   // private Date bithday;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public Date getBithday() {
//        return bithday;
//    }
//
//    public void setBithday(Date bithday) {
//        this.bithday = bithday;
//    }
}
