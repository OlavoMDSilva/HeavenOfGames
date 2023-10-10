package com.olavo.finalproject.pages;

import com.olavo.finalproject.TestFXBase;
import javafx.scene.control.TextField;

import static com.olavo.finalproject.JavaFXIds.*;

public class GenrePage {

    private final TestFXBase driver;

    public GenrePage(TestFXBase driver) {
        this.driver = driver;
    }

    public GenrePage register(String genre) {
        clearInputs();
        enterName(genre);
        submit();
        return this;
    }

    public GenrePage enterName(String name) {
        driver.clickOn(EDT_NAME).write(name);
        return this;
    }

    public GenrePage submit() {
        driver.clickOn(BTN_REGISTER);
        return this;
    }

    public GenrePage clearInputs() {
        clearName();
        return this;
    }

    public GenrePage clearName() {
        TextField name = driver.find(EDT_NAME);
        name.clear();
        return this;
    }

    
}
