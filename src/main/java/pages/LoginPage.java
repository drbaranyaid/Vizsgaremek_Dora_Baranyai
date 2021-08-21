package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By USER_NAME = By.xpath("//*[@id=\"wpName1\"]");
    private final By PASSWORD_BUTTON = By.cssSelector("#wpPassword1");
    private final By LOGIN_FINAL_BUTTON = By.cssSelector("#wpLoginAttempt");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void typeUserName(String user){
        driver.findElement(USER_NAME).sendKeys(user);
    }

    public void typePassword(String pass){
        driver.findElement(PASSWORD_BUTTON).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN_FINAL_BUTTON).click();
        new FirstPage(driver);
    }

    public void ValidLogin(){

        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        String user = "KisVirág9";
        typeUserName(user);
        String pass = "kukac423";
        typePassword(pass);
        clickLoginButton();
    }

}
