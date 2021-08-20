package createAccountPage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateAccountPage;

import java.io.ByteArrayInputStream;


public class createAccountPageTest extends BaseTest {

/*Az oldalt érintő, a tesztmenedzser mappában található regisztrációs tesztesetek (TC01-TC03) manuálisan kerültek elvégzésre, tekintettel arra,
 hogy a Github-on történő futtatás során készült fényképfelvételeknek megfelelőn a futtatás során használt IP cím blokkolásra került a Wikipédia
 által feltehetőleg automata tevékenységek észlelése okán. Az account creation error-ról, illetve a blokkolásról készült screenshot megtekinthető
  az alábbi CreateAccountCheck() teszt reportjának a mappájában a Github-on*/

    @Test
    public void CreateAccountCheck() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        TakeScreenshot2();
        homePage.clickCreateAccountButton();
        TakeScreenshot2();
        createAccountPage.typeUserNameToCreateAccount(user);
        TakeScreenshot2();
        createAccountPage.typePasswordToCreateAccount(pass);
        TakeScreenshot2();
        createAccountPage.typeEmailToCreateAccount(email);
        TakeScreenshot2();
        createAccountPage.clickCreateAccountButton();
        TakeScreenshot2();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", getDriver().getCurrentUrl());
    }
    @Step("TakeScreenshot2")
    public void TakeScreenshot2(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

}
