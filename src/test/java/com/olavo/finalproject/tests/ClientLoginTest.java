package com.olavo.finalproject.tests;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.TestFXBase;
import com.olavo.finalproject.pages.ClientLoginPage;
import javafx.application.Platform;
import javafx.scene.control.Label;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxAssert;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;

import static com.olavo.finalproject.JavaFXIds.LBL_ERROR;

@RunWith(JUnitParamsRunner.class)
public class ClientLoginTest extends TestFXBase {

    private ClientLoginPage clientLoginPage;

    @Before
    public void beforeEachTest() {
        Platform.runLater(() -> {
            try {
                Main.switchScene("ClientLoginWin");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        clientLoginPage = new ClientLoginPage(this);
    }

    @Test
    @Parameters(method = "wrongClients")
    public void wrongClientLoginTest(String user, String password) {
        clientLoginPage.login(user, password);

        FxAssert.verifyThat(LBL_ERROR, (Label error) -> {
            String text = error.getText();
            return text.contains("Invalid User or Password!");
        });
    }

    @Test
    @Parameters(method = "validClients")
    public void validClientLoginTest(String user, String password) {
        WaitForAsyncUtils.waitForFxEvents();
        clientLoginPage.login(user, password);
    }

    @Test
    @Parameters(method = "validation")
    public void validationsTest(String user, String password) {
        WaitForAsyncUtils.waitForFxEvents();
        clientLoginPage.login(user, password);
    }

    private Object[] wrongClients() {
        return new Object[] {
                new Object[]{"Adm1234", "123454"},
                new Object[]{"Jo", "123321"},
                new Object[]{"Arthur", "123456"},
                new Object[]{"Kelvim", "019283"},
                new Object[]{"Olavo21", "271423"}
        };
    }

    private Object[] validClients() {
        return new Object[] {
                new Object[]{"Olavo", "123454"},
                new Object[]{"Pedro", "123321"},
                new Object[]{"Kelvyn", "15234"},
                new Object[]{"lid", "105674"}
        };
    }

    private Object[] validation() {
        return new Object[] {
                new Object[]{"", ""},
                new Object[]{"Olavo", ""},
                new Object[]{"", "123454"}
        };
    }

}
