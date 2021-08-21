package firstPage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    public String expectedURL = "https://en.wikipedia.org/wiki/Main_Page";
    public String data = "Log in";


    @Test
    @DisplayName("TC06-Kijelentkezés tesztelése")
    public void LogoutTest() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        TakeScreenshot2();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        TakeScreenshot2();
        homePage = new HomePage(driver);
        Assertions.assertTrue(driver.findElement(homePage.LOGIN_BUTTON).getText().contains(data));
    }

    @Test
    @DisplayName("TC07-Kijelentkezés tesztelése")
    public void LogoutTest2() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        TakeScreenshot2();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        TakeScreenshot2();
        homePage = new HomePage(driver);
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl());
    }


    @Step("TakeScreenshot2")
    public void TakeScreenshot2(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}
