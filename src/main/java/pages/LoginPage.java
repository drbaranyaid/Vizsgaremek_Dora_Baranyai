package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By userName = By.xpath("//*[@id=\"wpName1\"]");
    private final By passwordButton = By.cssSelector("#wpPassword1");
    private final By loginFinalButton = By.cssSelector("#wpLoginAttempt");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void typeUserName(String user){
        driver.findElement(userName).sendKeys(user);
    }

    public void typePassword(String pass){
        driver.findElement(passwordButton).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginFinalButton).click();
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
