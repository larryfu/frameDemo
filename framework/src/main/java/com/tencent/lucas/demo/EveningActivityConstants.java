package com.tencent.lucas.demo;

/**
 * Created by lucasfu on 2016/12/30.
 */
public class EveningActivityConstants {
}

enum BonusPoolStatus {
    NOTOPEN(0, "未开启"),
    OPENED(1, "进行中"),
    CLOSED(2, "已关闭"),
    COMPUTING(3, "计算中"),
    FINISHED(4, "计算完成");
    private int value;
    private String name;

    BonusPoolStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum UserAwardStatus {
    NOTGRANT(0, "未发放"),
    GRANTING(1, "发放中"),
    GRANTED(2, "发放完成"),
    GRANT_TIMEOUT(3, "发放超时");
    private int value;
    private String name;

    UserAwardStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}