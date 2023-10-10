package com.olavo.finalproject.pages;

import com.olavo.finalproject.TestFXBase;
import javafx.scene.control.TextField;

import static com.olavo.finalproject.JavaFXIds.*;

public class CompanyPage {

    private final TestFXBase driver;

    public CompanyPage(TestFXBase driver) {
        this.driver = driver;
    }

    public CompanyPage register(String name, String email, String phone) {
        clearInputs();
        enterName(name).enterEmail(email).enterPhone(phone);
        submit();
        return this;
    }

    public CompanyPage enterName(String name) {
        driver.clickOn(EDT_NAME).write(name);
        return this;
    }

    public CompanyPage enterEmail(String email) {
        driver.clickOn(EDT_EMAIL).write(email);
        return this;
    }

    public CompanyPage enterPhone(String phone) {
        driver.clickOn(EDT_PHONE).write(phone);
        return this;
    }

    public CompanyPage submit() {
        driver.clickOn(BTN_REGISTER);
        return this;
    }

    public CompanyPage clearInputs() {
        clearName().clearEmail().clearPhone();
        return this;
    }

    public CompanyPage clearName() {
        TextField name = driver.find(EDT_NAME);
        name.clear();
        return this;
    }

    public CompanyPage clearEmail() {
        TextField email = driver.find(EDT_EMAIL);
        email.clear();
        return this;
    }

    public CompanyPage clearPhone() {
        TextField phone = driver.find(EDT_PHONE);
        phone.clear();
        return this;
    }


}
