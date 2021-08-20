package homepage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.FirstPage;
import pages.LoginPage;
import utils.Utils;

import java.io.ByteArrayInputStream;


public class HomePageTest extends BaseTest {
    public By searchedField = By.xpath("//*[@id=\"mp-itn\"]");

    /*Erre a tesztre azért volt szükségem, hogy megállapítsam, hogy automata illetve manuális tesztelés esetén ugyanaz az oldal töltődik-e be
    nem képezi az érdemi teszttevékenység részét*/
    @Test
    public void pageCheckLogin() {
        homePage.clickLoginButton();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page", getDriver().getCurrentUrl());
    }


    /*Erre a tesztre azért volt szükségem, hogy megállapítsam, hogy automata illetve manuális tesztelés esetén ugyanaz az oldal töltődik-e be
      nem képezi az érdemi teszttevékenység részét*/
    @Test
    public void pageCheckCreateAccount() {
        homePage.clickCreateAccountButton();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", getDriver().getCurrentUrl());
    }


    @Test
    @DisplayName("TC12-Privacy Policy/present,Adatkezelési nyilatkozat használata")
    public void PrivacyPolicyUse() {
        homePage.clickPrivacyPolicyButton();
        Utils utils=new Utils(driver);
        Utils.scrollDown(driver);
        Assertions.assertEquals("Privacy policy", driver.findElement(By.xpath("//*[@id='mw-normal-catlinks']/ul/li[1]/a")).getText());
    }

    @Test
    @DisplayName("TC13-Privacy Policy/link ,Adatkezelési nyilatkozat használata")
    public void testPrivacyAndPolicyLink() {
        homePage.clickPrivacyPolicyButton();
        Assertions.assertEquals("https://foundation.wikimedia.org/wiki/Privacy_policy", driver.getCurrentUrl());
    }

    /*Érdemi teszttevékenységhez nem tartozó teszt,manuális és automata tesztelési tevékenység elhatárolásához volt szükséges */
    @Test
    public void SearchDataLink() {
        homePage.searchDataGeneral("font types");
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=font+types&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
    }


    @Test
    @DisplayName("TC24-Search/ismételt és sorozatos adatbevitel adatforrásból")
    public void SearchRepeatedDataCheckedWithAllData() {
        homePage.repeatedMultiInputSearch();
        homePage.searchData();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=The+black+tea+bad+effects+to+an+organism&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral("black tea bad effects"));
    }

    @Test
    @DisplayName("TC26- új adatok bevitele, meglévő adat módosítása és törlése")
    public void SearchInputClearModifyData() {
        homePage.searchDataGeneral("old data");
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=old+data&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        By SEARCH_RESULT = By.xpath("//*[@id=\"ooui-php-1\"]");
        String result = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals("old data", result);
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral("data"));
        driver.findElement(SEARCH_RESULT).clear();
        String result2 = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals("", result2);
        driver.findElement(SEARCH_RESULT).sendKeys("new data modification");
        driver.findElement(By.xpath("//*[@id=\"mw-search-top-table\"]/div[1]/div/div/span/span/button/span[2]")).click();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=new+data+modification&title=Special:Search&profile=advanced&fulltext=1&ns0=1", driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral("New"));
    }
    @Test
    @DisplayName("TC25-Adatok lementése felületről2")
    public void SaveToFile2() {
        FirstPage firstPage= new FirstPage(driver);
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





