package com.example.mealrecipes;

import java.io.Serializable;

public class Meal implements Serializable {

    private int mealImage;
    private int counter;
    private String mealName;
    private String mealInfo;
    private int price;
    private String mealDescription;
    private String mealComposition;
    private String mealValueInfo;
    private String grammJir;
    private String grammNasJir;
    private String grammUglevod;
    private String grammSahar;
    private String grammKletchatka;
    private String grammBelki;
    private String grammSol;
    private String procJir;
    private String procNasJir;
    private String procUglevod;
    private String procSahar;
    private String procKletchatka;
    private String procBelki;
    private String procSol;
    private String calory;

    public Meal(int mealImage, String mealName, String mealInfo, int price, String mealComposition, String grammJir, String grammNasJir, String grammUglevod, String grammSahar, String grammKletchatka, String grammBelki, String grammSol, String procJir, String procNasJir, String procUglevod, String procSahar, String procKletchatka, String procBelki, String procSol, String calory, int counter) {
        this.mealImage = mealImage;
        this.mealName = mealName;
        this.mealInfo = mealInfo;
        this.price = price;
        this.mealComposition = mealComposition;
        this.grammJir = grammJir;
        this.grammNasJir = grammNasJir;
        this.grammUglevod = grammUglevod;
        this.grammSahar = grammSahar;
        this.grammKletchatka = grammKletchatka;
        this.grammBelki = grammBelki;
        this.grammSol = grammSol;
        this.procJir = procJir;
        this.procNasJir = procNasJir;
        this.procUglevod = procUglevod;
        this.procSahar = procSahar;
        this.procKletchatka = procKletchatka;
        this.procBelki = procBelki;
        this.procSol = procSol;
        this.calory = calory;
        this.counter = counter;
    }
//    public Meal(){}

    public int getMealImage() {
        return mealImage;
    }

    public void setMealImage(int mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealInfo() {
        return mealInfo;
    }

    public void setMealInfo(String mealInfo) {
        this.mealInfo = mealInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMealComposition() {
        return mealComposition;
    }

    public void setMealComposition(String mealComposition) {
        this.mealComposition = mealComposition;
    }

    public String getMealValueInfo() {
        return mealValueInfo;
    }

    public void setMealValueInfo(String mealValueInfo) {
        this.mealValueInfo = mealValueInfo;
    }

    public String getGrammJir() {
        return grammJir;
    }

    public void setGrammJir(String grammJir) {
        this.grammJir = grammJir;
    }

    public String getGrammNasJir() {
        return grammNasJir;
    }

    public void setGrammNasJir(String grammNasJir) {
        this.grammNasJir = grammNasJir;
    }

    public String getGrammUglevod() {
        return grammUglevod;
    }

    public void setGrammUglevod(String grammUglevod) {
        this.grammUglevod = grammUglevod;
    }

    public String getGrammSahar() {
        return grammSahar;
    }

    public void setGrammSahar(String grammSahar) {
        this.grammSahar = grammSahar;
    }

    public String getGrammKletchatka() {
        return grammKletchatka;
    }

    public void setGrammKletchatka(String grammKletchatka) {
        this.grammKletchatka = grammKletchatka;
    }

    public String getGrammBelki() {
        return grammBelki;
    }

    public void setGrammBelki(String grammBelki) {
        this.grammBelki = grammBelki;
    }

    public String getGrammSol() {
        return grammSol;
    }

    public void setGrammSol(String grammSol) {
        this.grammSol = grammSol;
    }

    public String getProcJir() {
        return procJir;
    }

    public void setProcJir(String procJir) {
        this.procJir = procJir;
    }

    public String getProcNasJir() {
        return procNasJir;
    }

    public void setProcNasJir(String procNasJir) {
        this.procNasJir = procNasJir;
    }

    public String getProcUglevod() {
        return procUglevod;
    }

    public void setProcUglevod(String procUglevod) {
        this.procUglevod = procUglevod;
    }

    public String getProcSahar() {
        return procSahar;
    }

    public void setProcSahar(String procSahar) {
        this.procSahar = procSahar;
    }

    public String getProcKletchatka() {
        return procKletchatka;
    }

    public void setProcKletchatka(String procKletchatka) {
        this.procKletchatka = procKletchatka;
    }

    public String getProcBelki() {
        return procBelki;
    }

    public void setProcBelki(String procBelki) {
        this.procBelki = procBelki;
    }

    public String getProcSol() {
        return procSol;
    }

    public void setProcSol(String procSol) {
        this.procSol = procSol;
    }

    public String getCalory() {
        return calory;
    }

    public void setCalory(String calory) {
        this.calory = calory;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
