package firstPage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.ByteArrayInputStream;


public class FirstPageTest extends BaseTest {

    FirstPage firstPage;
    HomePage homePage;
    LoginPage loginPage;

    public By searchedField = By.xpath("//*[@id=\"mp-itn\"]");


    @Test
    @DisplayName("TC06-Kijelentkezés tesztelése")
    public void LogoutTest() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        homePage = new HomePage(driver);
        Assertions.assertTrue(driver.findElement(homePage.loginButton).getText().contains("Log in"));
    }

    @Test
    @DisplayName("TC07-Kijelentkezés tesztelése")
    public void LogoutTest2() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        homePage = new HomePage(driver);
        Assertions.assertEquals("https://en.wikipedia.org/wiki/Main_Page",driver.getCurrentUrl());
    }
    @Disabled
    @Test
    @DisplayName("TC25-Adatok lementése felületről") // bejelentkezés captcha-t kér
    public void SaveToFile() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        TakeScreenshot2();
        firstPage = new FirstPage(driver);
        TakeScreenshot2();
        firstPage.writeToAFile();
        TakeScreenshot2();
        Assertions.assertTrue(firstPage.writeToAFile().toString().contains("Nominate an article"));
        Assertions.assertEquals(driver.findElement(searchedField).getText()+"\n",firstPage.writeToAFile().toString());
    }
    @Step("TakeScreenshot2")
    public void TakeScreenshot2(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}
