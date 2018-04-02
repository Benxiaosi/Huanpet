package com.example.huanpet.view.activity.home.bean;

/**
 * Created by leon on 2018/4/2.
 */

public class AnimalBean {
    private String petPrice;
    private String petTypeImage;
    private String typeName;

    @Override
    public String toString() {
        return "AnimalBean{" +
                "petPrice='" + petPrice + '\'' +
                ", petTypeImage='" + petTypeImage + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(String petPrice) {
        this.petPrice = petPrice;
    }

    public String getPetTypeImage() {
        return petTypeImage;
    }

    public void setPetTypeImage(String petTypeImage) {
        this.petTypeImage = petTypeImage;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public AnimalBean(String petPrice, String petTypeImage, String typeName) {

        this.petPrice = petPrice;
        this.petTypeImage = petTypeImage;
        this.typeName = typeName;
    }
}
