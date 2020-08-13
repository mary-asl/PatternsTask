package com.epam.task5.tests.businessObject;

import org.openqa.selenium.WebDriver;

public class Locale {

    private String country;
    WebDriver driver;

    public Locale(WebDriver driver) {
        this.driver = driver;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
