package com.olavo.finalproject.tests;

import com.olavo.finalproject.TestFXBase;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;

import static com.olavo.finalproject.JavaFXIds.*;

public class GoBackTest extends TestFXBase {

    @Test
    public void companyBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testAdmGoBackFromWin(BTN_COMPANY);
        for (int i = 0; i < 3; i++) {
            clickOn(BTN_BACK);
        }
    }

    @Test
    public void genreBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testAdmGoBackFromWin(BTN_GENRE);
        for (int i = 0; i < 3; i++) {
            clickOn(BTN_BACK);
        }
    }

    @Test
    public void gameBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testAdmGoBackFromWin(BTN_GAMES);
        for (int i = 0; i < 3; i++) {
            clickOn(BTN_BACK);
        }
    }

    @Test
    public void clientRegisterBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testClientGoBackFromWin(BTN_SIGN_UP);
        for (int i = 0; i < 2; i++) {
            clickOn(BTN_BACK);
        }
    }

    @Test
    public void clientDeleteBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testClientGoBackFromWin(BTN_ACCOUNT);
        for (int i = 0; i < 2; i++) {
            clickOn(BTN_BACK);
        }
    }

    @Test
    public void storeBackTest() {
        WaitForAsyncUtils.waitForFxEvents();
        testClientGoBackFromWin(BTN_SIGN_IN);
        clickOn(EDT_USER).write("Olavo");
        clickOn(PSW_PASS).write("123454");
        clickOn(BTN_CONFIRM);
        for (int i = 0; i < 3; i++) {
            clickOn(BTN_BACK);
        }
    }

    private void testAdmGoBackFromWin(String buttonWinId) {
        clickOn(BTN_ADM);
        clickOn(EDT_USER).write("adm");
        clickOn(PSW_PASS).write("123");
        clickOn(BTN_CONFIRM);
        clickOn(buttonWinId);
    }

    private void testClientGoBackFromWin(String buttonWinId) {
        clickOn(BTN_CLIENT);
        clickOn(buttonWinId);
    }

}
