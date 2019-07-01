import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class MainPage extends PageObject {
    private String REDCOLOR = "arguments[0].style.border='2px solid red'";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private String DIV_BUTTON_ID = "finish";//couldnt find a better way.

    @FindBy(how = How.XPATH, using = "//button[text()='Start']")
    WebElement button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"finish\"]/h4")
    WebElement clickResult;

    public boolean isButtonInitialized() {
        try {

            if (!button.isDisplayed()) {
                System.out.println("Element Not Visible");
                return false;
            }
            if (!button.isEnabled()) {
                System.out.println("Element Disable");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
        return true;
    }

    public boolean clickButton() {

        try {
            button.click();
            System.out.println("clicked button");
            return true;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }

    }

    public Boolean verifyMessage(String currentMessage) {
        WebElement webElement;
        String result;

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DIV_BUTTON_ID)));
            result = webElement.getText();
            if (!result.contentEquals(currentMessage)) {
                highlightElement();
                printWrongValidationMessage();
                return false;
            } else {
                return true;
            }

        } catch (TimeoutException ex) {
            System.out.println(ex.getCause());

        }
        return false;
    }


    // -------------------- PRIVATE METHODS -------------------- //
    private void highlightElement() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript(REDCOLOR, new Object[]{this.clickResult});
    }

    private void printWrongValidationMessage() {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("D:/errorWrongValidationMessage.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
