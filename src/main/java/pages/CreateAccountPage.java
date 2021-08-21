package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class CreateAccountPage {

    private final WebDriver driver;
    private final By CREATE_USER_NAME = By.xpath("//*[@id='wpName2']");
    private final By CREATE_PASSWORD = By.cssSelector("#wpPassword2");
    private final By EMAIL_FIELD = By.xpath(("//*[@id='wpEmail']"));
    private final By CREATE_ACCOUNT_BUTTON =By.xpath("//button[@id='wpCreateaccount']");

    public CreateAccountPage(WebDriver driver) {
        this.driver=driver;
    }

    public void typeUserNameToCreateAccount(String user){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(CREATE_USER_NAME).sendKeys(user);
    }
    public void typePasswordToCreateAccount(String pass){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(CREATE_PASSWORD).sendKeys(pass);
    }

    public void typeEmailToCreateAccount(String email){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public FirstPage clickCreateAccountButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new FirstPage(driver);
    }
}
