package com.olavo.finalproject.tests;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.TestFXBase;
import com.olavo.finalproject.pages.AdmPage;
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

import static com.olavo.finalproject.JavaFXIds.*;

@RunWith(JUnitParamsRunner.class)
public class AdmLoginTest extends TestFXBase {

    public final String VALID_USER = "Adm";
    public final String VALID_PASSWORD = "123";
    private AdmPage admPage;

    @Before
    public void beforeEachTest() {
        Platform.runLater(() -> {
            try {
                Main.switchScene("AdmLoginWin");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        admPage = new AdmPage(this);
    }

    @Test
    @Parameters(method = "parametersForIncorrectLogins")
    public void wrongLogin(String user, String password) {
        WaitForAsyncUtils.waitForFxEvents();
        admPage.login(user, password);

        WaitForAsyncUtils.waitForFxEvents();

        FxAssert.verifyThat(LBL_ERROR, (Label error) -> {
            String text = error.getText();
            return text.contains("Invalid User or Password!");
        });
    }

    @Test
    public void correctLogin() {
        WaitForAsyncUtils.waitForFxEvents();
        admPage.login(VALID_USER, VALID_PASSWORD);
    }

    private Object[] parametersForIncorrectLogins() {
        String BAD_USER = "badUser";
        String BAD_PASSWORD = "badPassword";

        return new Object[] {
                new Object[]{BAD_USER, BAD_PASSWORD},
                new Object[]{BAD_USER, VALID_PASSWORD},
                new Object[]{VALID_USER, BAD_PASSWORD},
                new Object[]{"", ""}
        };
    }

}
