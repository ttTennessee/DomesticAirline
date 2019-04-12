package com.qinzheng.airline.pojo;

public class Address {
    private String enCityName;
    private String cnCityName;
    private String Abbreviation;

    @Override
    public String toString() {
        return "Address{" +
                "enCityName='" + enCityName + '\'' +
                ", cnCityName='" + cnCityName + '\'' +
                ", Abbreviation='" + Abbreviation + '\'' +
                '}';
    }

    public String getEnCityName() {
        return enCityName;
    }

    public void setEnCityName(String enCityName) {
        this.enCityName = enCityName;
    }

    public String getCnCityName() {
        return cnCityName;
    }

    public void setCnCityName(String cnCityName) {
        this.cnCityName = cnCityName;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }
}
