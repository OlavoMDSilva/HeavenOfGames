package com.olavo.finalproject.pages;

import com.olavo.finalproject.TestFXBase;
import javafx.scene.control.TextField;

import static com.olavo.finalproject.JavaFXIds.*;

public class AdmPage {

    private final TestFXBase driver;

    public AdmPage(TestFXBase driver) {
        this.driver = driver;
    }

    public AdmPage login(String user, String password) {
        clearInputs();
        enterUser(user).enterPassword(password);
        submit();
        return this;
    }

    public AdmPage enterUser(String user) {
        driver.clickOn(EDT_USER).write(user);
        return this;
    }

    public AdmPage enterPassword(String password) {
        driver.clickOn(PSW_PASS).write(password);
        return this;
    }

    public AdmPage submit() {
        driver.clickOn(BTN_CONFIRM);
        return this;
    }

    public AdmPage clearInputs() {
        clearUserInput().clearPasswordInput();
        return this;
    }

    public AdmPage clearUserInput() {
        TextField user = driver.find(EDT_USER);
        user.clear();
        return this;
    }

    public AdmPage clearPasswordInput() {
        TextField pass = driver.find(PSW_PASS);
        pass.clear();
        return this;
    }

}
