package com.tencent.lucas.demo.protouf;

import io.protostuff.Tag;


/**
 * Created by lucasfu on 2016/12/21.
 */
public class ActivityMessage extends ProtoBase {


    @Tag(1)
    private int sendTime;  //unix 时间戳
    @Tag(2)
    private int giftId;
    @Tag(3)
    private int giftPrice;
    @Tag(4)
    private int amount;
    @Tag(5)
    private long senderUin;
    @Tag(6)
    private long receiverUin;
    @Tag(7)
    private String giftName;


    public long getSenderUin() {
        return senderUin;
    }

    public void setSenderUin(long senderUin) {
        this.senderUin = senderUin;
    }

    public long getReceiverUin() {
        return receiverUin;
    }

    public void setReceiverUin(long receiverUin) {
        this.receiverUin = receiverUin;
    }


    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public int getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(int giftPrice) {
        this.giftPrice = giftPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSendTime() {
        return sendTime;
    }

    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }
}
