package com.architecture.projectsix.bean;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */
public class User {
    private String name;
    private String sex;
    private String phone;
    private String card;

    public User(String name, String sex, String phone, String card) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
