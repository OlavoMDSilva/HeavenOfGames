package com.olavo.finalproject.tests;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.TestFXBase;
import com.olavo.finalproject.pages.GenrePage;
import javafx.application.Platform;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;

@RunWith(JUnitParamsRunner.class)
public class GenreRegisterTest extends TestFXBase {

    private GenrePage genrePage;

    @Before
    public void beforeEachTest() {
        Platform.runLater(() -> {
            try {
                Main.switchScene("GenreWin");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(1000); // Sleep for 1 second, adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genrePage = new GenrePage(this);
    }

    @Test
    @Parameters(method = "genresToRegister")
    public void genresRegister(String genre) {
        WaitForAsyncUtils.waitForFxEvents();
        genrePage.register(genre);
    }

    @Test
    public void testValidations() {
        WaitForAsyncUtils.waitForFxEvents();
        genrePage.register("");
    }

    private Object[] genresToRegister() {
        return new Object[] {
                new Object[]{"Action"},
                new Object[]{"Adventure"},
                new Object[]{"RPG"},
                new Object[]{"Sand-Box"},
                new Object[]{"FPS"}
        };
    }

}
