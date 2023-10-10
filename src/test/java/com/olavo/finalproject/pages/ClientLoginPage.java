package com.olavo.finalproject.pages;

import com.olavo.finalproject.TestFXBase;
import javafx.scene.control.TextField;

import static com.olavo.finalproject.JavaFXIds.*;
import static com.olavo.finalproject.JavaFXIds.PSW_PASS;

public class ClientLoginPage {
    
    private final TestFXBase driver;

    public ClientLoginPage(TestFXBase driver) {
        this.driver = driver;
    }

    public ClientLoginPage login(String user, String password) {
        clearInputs();
        enterUser(user).enterPassword(password);
        submit();
        return this;
    }

    public ClientLoginPage enterUser(String user) {
        driver.clickOn(EDT_USER).write(user);
        return this;
    }

    public ClientLoginPage enterPassword(String password) {
        driver.clickOn(PSW_PASS).write(password);
        return this;
    }

    public ClientLoginPage submit() {
        driver.clickOn(BTN_CONFIRM);
        return this;
    }

    public ClientLoginPage clearInputs() {
        clearUserInput().clearAdmPasswordInput();
        return this;
    }

    public ClientLoginPage clearUserInput() {
        TextField user = driver.find(EDT_USER);
        user.clear();
        return this;
    }

    public ClientLoginPage clearAdmPasswordInput() {
        TextField pass = driver.find(PSW_PASS);
        pass.clear();
        return this;
    }
}
