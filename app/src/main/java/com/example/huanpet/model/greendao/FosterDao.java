package com.example.huanpet.model.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 本丶小丝 on 2018/3/25.
 */
@Entity
public class FosterDao {
    @Id(autoincrement = true)
    private Long id;
    //订单编号
    private String orderNumber;
    //寄养主人头像
    private String buyersImg;
    //寄养主人名字
    private String buyersName;
    //寄养主人手机号
    private String buyersPhone;
    //寄养宠物头像
    private String pitImg;
    //寄养宠物简介
    private String pitText;
    //寄养宠物名字
    private String pitName;
    //寄养宠物开始时间
    private String pitBeginTime;
    //寄养宠物结束时间
    private String pitStopTime;
    //寄养宠物天数
    private String pitDaiTime;
    //寄养宠物总价格
    private String pitPrice;
    //寄养订单状态
    private String pitState;
    //备注
    private String Remarks;
    @Generated(hash = 371367261)
    public FosterDao(Long id, String orderNumber, String buyersImg,
            String buyersName, String buyersPhone, String pitImg, String pitText,
            String pitName, String pitBeginTime, String pitStopTime,
            String pitDaiTime, String pitPrice, String pitState, String Remarks) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.buyersImg = buyersImg;
        this.buyersName = buyersName;
        this.buyersPhone = buyersPhone;
        this.pitImg = pitImg;
        this.pitText = pitText;
        this.pitName = pitName;
        this.pitBeginTime = pitBeginTime;
        this.pitStopTime = pitStopTime;
        this.pitDaiTime = pitDaiTime;
        this.pitPrice = pitPrice;
        this.pitState = pitState;
        this.Remarks = Remarks;
    }
    @Generated(hash = 545668004)
    public FosterDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderNumber() {
        return this.orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getBuyersImg() {
        return this.buyersImg;
    }
    public void setBuyersImg(String buyersImg) {
        this.buyersImg = buyersImg;
    }
    public String getBuyersName() {
        return this.buyersName;
    }
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }
    public String getBuyersPhone() {
        return this.buyersPhone;
    }
    public void setBuyersPhone(String buyersPhone) {
        this.buyersPhone = buyersPhone;
    }
    public String getPitImg() {
        return this.pitImg;
    }
    public void setPitImg(String pitImg) {
        this.pitImg = pitImg;
    }
    public String getPitText() {
        return this.pitText;
    }
    public void setPitText(String pitText) {
        this.pitText = pitText;
    }
    public String getPitName() {
        return this.pitName;
    }
    public void setPitName(String pitName) {
        this.pitName = pitName;
    }
    public String getPitBeginTime() {
        return this.pitBeginTime;
    }
    public void setPitBeginTime(String pitBeginTime) {
        this.pitBeginTime = pitBeginTime;
    }
    public String getPitStopTime() {
        return this.pitStopTime;
    }
    public void setPitStopTime(String pitStopTime) {
        this.pitStopTime = pitStopTime;
    }
    public String getPitDaiTime() {
        return this.pitDaiTime;
    }
    public void setPitDaiTime(String pitDaiTime) {
        this.pitDaiTime = pitDaiTime;
    }
    public String getPitPrice() {
        return this.pitPrice;
    }
    public void setPitPrice(String pitPrice) {
        this.pitPrice = pitPrice;
    }
    public String getPitState() {
        return this.pitState;
    }
    public void setPitState(String pitState) {
        this.pitState = pitState;
    }
    public String getRemarks() {
        return this.Remarks;
    }
    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

}
