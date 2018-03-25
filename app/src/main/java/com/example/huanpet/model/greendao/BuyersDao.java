package com.example.huanpet.model.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 本丶小丝 on 2018/3/25.
 */
@Entity
public class BuyersDao {
    @Id(autoincrement = true)
    private Long id;
    //寄养家头像
    private String fosterImg;
    //订单编号
    private String orderNumber;
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
    //是否洗澡
    private Boolean bathing;
    //洗澡价格
    private String bathingPrice;
    //洗澡次数
    private String bathingFrequency;
    //是否学习
    private Boolean study;
    //学习价格
    private Boolean studyPrice;
    //是否接送
    private Boolean shuttle;
    //接送次数
    private int shuttleFrequency;
    //接送价格
    private Boolean shuttlePrice;
    //备注
    private String remarks;
    //寄养家名字
    private String fosterName;
    //评价等级
    private int ranking;
    @Generated(hash = 508833626)
    public BuyersDao(Long id, String fosterImg, String orderNumber, String pitImg,
            String pitText, String pitName, String pitBeginTime, String pitStopTime,
            String pitDaiTime, String pitPrice, String pitState, Boolean bathing,
            String bathingPrice, String bathingFrequency, Boolean study,
            Boolean studyPrice, Boolean shuttle, int shuttleFrequency,
            Boolean shuttlePrice, String remarks, String fosterName, int ranking) {
        this.id = id;
        this.fosterImg = fosterImg;
        this.orderNumber = orderNumber;
        this.pitImg = pitImg;
        this.pitText = pitText;
        this.pitName = pitName;
        this.pitBeginTime = pitBeginTime;
        this.pitStopTime = pitStopTime;
        this.pitDaiTime = pitDaiTime;
        this.pitPrice = pitPrice;
        this.pitState = pitState;
        this.bathing = bathing;
        this.bathingPrice = bathingPrice;
        this.bathingFrequency = bathingFrequency;
        this.study = study;
        this.studyPrice = studyPrice;
        this.shuttle = shuttle;
        this.shuttleFrequency = shuttleFrequency;
        this.shuttlePrice = shuttlePrice;
        this.remarks = remarks;
        this.fosterName = fosterName;
        this.ranking = ranking;
    }
    @Generated(hash = 790964009)
    public BuyersDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFosterImg() {
        return this.fosterImg;
    }
    public void setFosterImg(String fosterImg) {
        this.fosterImg = fosterImg;
    }
    public String getOrderNumber() {
        return this.orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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
    public Boolean getBathing() {
        return this.bathing;
    }
    public void setBathing(Boolean bathing) {
        this.bathing = bathing;
    }
    public String getBathingPrice() {
        return this.bathingPrice;
    }
    public void setBathingPrice(String bathingPrice) {
        this.bathingPrice = bathingPrice;
    }
    public String getBathingFrequency() {
        return this.bathingFrequency;
    }
    public void setBathingFrequency(String bathingFrequency) {
        this.bathingFrequency = bathingFrequency;
    }
    public Boolean getStudy() {
        return this.study;
    }
    public void setStudy(Boolean study) {
        this.study = study;
    }
    public Boolean getStudyPrice() {
        return this.studyPrice;
    }
    public void setStudyPrice(Boolean studyPrice) {
        this.studyPrice = studyPrice;
    }
    public Boolean getShuttle() {
        return this.shuttle;
    }
    public void setShuttle(Boolean shuttle) {
        this.shuttle = shuttle;
    }
    public int getShuttleFrequency() {
        return this.shuttleFrequency;
    }
    public void setShuttleFrequency(int shuttleFrequency) {
        this.shuttleFrequency = shuttleFrequency;
    }
    public Boolean getShuttlePrice() {
        return this.shuttlePrice;
    }
    public void setShuttlePrice(Boolean shuttlePrice) {
        this.shuttlePrice = shuttlePrice;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getFosterName() {
        return this.fosterName;
    }
    public void setFosterName(String fosterName) {
        this.fosterName = fosterName;
    }
    public int getRanking() {
        return this.ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
