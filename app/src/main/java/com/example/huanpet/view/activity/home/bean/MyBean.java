package com.example.huanpet.view.activity.home.bean;

/**
 * Created by leon on 2018/3/30.
 */

public class MyBean {
    private String address;
    private String family;
    private String userImage;
    private int score;
    private String price;

    @Override
    public String toString() {
        return "MyBean{" +
                "address='" + address + '\'' +
                ", family='" + family + '\'' +
                ", userImage='" + userImage + '\'' +
                ", score=" + score +
                ", price='" + price + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MyBean(String address, String family, String userImage, int score, String price) {

        this.address = address;
        this.family = family;
        this.userImage = userImage;
        this.score = score;
        this.price = price;
    }
}
