
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestMainPage extends FunctionalTest {

    public String MESSAGE_VALID = "Hello World!";
    public String MESSAGE_INVALID = "Hey World!";

    /**
     * <b>Method Steps:</b><br>
     * - Verify button exist<br>
     * - Click button<br>
     * - Message received is valid<br>
     */
    @Test
    public void clickAndVerifyButton() {


        MainPage mainPage = new MainPage(driver);

        assertTrue("Expected - button exist and visible; Actual - NOT", mainPage.isButtonInitialized());
        assertTrue("Expected - button clicked; Actual - NOT", mainPage.clickButton());
        assertTrue("Expected - message received is '" + MESSAGE_VALID + "' Actual - NOT ", mainPage.verifyMessage(MESSAGE_VALID));
    }

    /**
     * <b>Method Steps:</b><br>
     * - Verify button exist<br>
     * - Click button<br>
     * - Message received is invalid<br>
     */
    @Test
    public void TestVerifyWrongResult() {

        MainPage mainPage = new MainPage(driver);

        assertTrue("Expected - button exist and visible; Actual - NOT", mainPage.isButtonInitialized());
        assertTrue("Expected - button clicked; Actual - NOT", mainPage.clickButton());
        assertTrue("Expected - message received is '" + MESSAGE_INVALID + "' Actual - NOT ", mainPage.verifyMessage(MESSAGE_INVALID));

    }
}
