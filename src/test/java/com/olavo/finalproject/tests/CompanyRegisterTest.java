package com.olavo.finalproject.tests;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.TestFXBase;
import com.olavo.finalproject.pages.CompanyPage;
import javafx.application.Platform;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;

@RunWith(JUnitParamsRunner.class)
public class CompanyRegisterTest extends TestFXBase {

    private CompanyPage companyPage;

    @Before
    public void beforeEachTest() {
        Platform.runLater(() -> {
            try {
                Main.switchScene("CompanyWin");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        companyPage = new CompanyPage(this);
    }

    @Test
    @Parameters(method = "companiesToRegister")
    public void companyRegisters(String name, String email, String phone) {
        WaitForAsyncUtils.waitForFxEvents();
        companyPage.register(name, email, phone);
    }

    @Test
    @Parameters(method = "toValidate")
    public void testValidations(String name, String email, String phone) {
        WaitForAsyncUtils.waitForFxEvents();
        companyPage.register(name, email, phone);
    }

    private Object[] companiesToRegister() {
        return new Object[] {
                new Object[]{"Mojang", "moj@gmail.com", "+55 (17) 99231-5123"},
                new Object[]{"Microsoft", "micro@gmail.com", "+55 (17) 99140-5123"},
                new Object[]{"Blizzard", "bliz@gmail.com", "+55 (17) 99390-8978"},
                new Object[]{"Re-Logic", "rlog@gmail.com", "+55 (17) 99130-5661"},
                new Object[]{"Capcom", "capcom@gmail.com", "+55 (17) 99275-2332"}
        };
    }

    private Object[] toValidate() {
        return new Object[][]{
                new Object[]{"", "", ""},
                new Object[]{"", "moj@gmail.com", "+55 (17) 99231-5123"},
                new Object[]{"Mojang", "", "+55 (17) 99231-5123"},
                new Object[]{"Mojang", "moj@gmail.com", ""}
        };
    }

}
