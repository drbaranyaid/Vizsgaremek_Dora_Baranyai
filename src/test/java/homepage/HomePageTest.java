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
import utils.Utils;

import java.io.ByteArrayInputStream;


public class HomePageTest extends BaseTest {
    public By searchedField = By.xpath("//*[@id=\"mp-itn\"]");
    public final By POLICY_LINK = (By.xpath("//*[@id='mw-normal-catlinks']/ul/li[1]/a"));
    public final By SEARCH_RESULT = By.xpath("//*[@id=\"ooui-php-1\"]");
    public final By BUTTON_SPAN = By.xpath("//*[@id=\"mw-search-top-table\"]/div[1]/div/div/span/span/button/span[2]");


    public String policyText = "Privacy policy";
    public String repeatedDataText = "black tea bad effects";
    public String saveToFileText = "Nominate an article";
    public String oldSearchText = "old data";
    public String data = "data";
    public String fontData = "font types";
    public String newSearchText = "New";
    public String newData = "new data modification";


    public String oldSearchURL = "https://en.wikipedia.org/w/index.php?search=old+data&title=Special%3ASearch&go=Go&ns0=1";
    public String policyURL = "https://foundation.wikimedia.org/wiki/Privacy_policy";
    public String newDataURL = "https://en.wikipedia.org/w/index.php?search=new+data+modification&title=Special:Search&profile=advanced&fulltext=1&ns0=1";
    public String loginURL = "https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page";
    public String accountURL = "https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page";
    public String searchFontURL = "https://en.wikipedia.org/w/index.php?search=font+types&title=Special%3ASearch&go=Go&ns0=1";
    public String repeatedResultURL = "https://en.wikipedia.org/w/index.php?search=The+black+tea+bad+effects+to+an+organism&title=Special%3ASearch&go=Go&ns0=1";

    /*Erre a tesztre az??rt volt sz??ks??gem, hogy meg??llap??tsam, hogy automata illetve manu??lis tesztel??s eset??n ugyanaz az oldal t??lt??dik-e be
    nem k??pezi az ??rdemi teszttev??kenys??g r??sz??t*/
    @Test
    public void pageCheckLogin() {
        homePage.clickLoginButton();
        Assertions.assertEquals(loginURL, getDriver().getCurrentUrl());
    }


    /*Erre a tesztre az??rt volt sz??ks??gem, hogy meg??llap??tsam, hogy automata illetve manu??lis tesztel??s eset??n ugyanaz az oldal t??lt??dik-e be
      nem k??pezi az ??rdemi teszttev??kenys??g r??sz??t*/
    @Test
    public void pageCheckCreateAccount() {
        homePage.clickCreateAccountButton();
        Assertions.assertEquals(accountURL, getDriver().getCurrentUrl());
    }


    @Test
    @DisplayName("TC12-Privacy Policy/present,Adatkezel??si nyilatkozat haszn??lata")
    public void PrivacyPolicyUse() {
        homePage.clickPrivacyPolicyButton();
        Utils.scrollDown(driver);
        Assertions.assertEquals(policyText, driver.findElement(POLICY_LINK).getText());
    }

    @Test
    @DisplayName("TC13-Privacy Policy/link ,Adatkezel??si nyilatkozat haszn??lata")
    public void testPrivacyAndPolicyLink() {
        homePage.clickPrivacyPolicyButton();
        Assertions.assertEquals(policyURL, driver.getCurrentUrl());
    }

    /*??rdemi teszttev??kenys??ghez nem tartoz?? teszt,manu??lis ??s automata tesztel??si tev??kenys??g elhat??rol??s??hoz volt sz??ks??ges */
    @Test
    public void SearchDataLink() {
        homePage.searchDataGeneral(fontData);
        Assertions.assertEquals(searchFontURL, driver.getCurrentUrl());
    }


    @Test
    @DisplayName("TC24-Search/ism??telt ??s sorozatos adatbevitel adatforr??sb??l")
    public void SearchRepeatedDataCheckedWithAllData() {
        homePage.repeatedMultiInputSearch();
        homePage.searchData();
        Assertions.assertEquals(repeatedResultURL, driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral(repeatedDataText));
    }

    @Test
    @DisplayName("TC26- ??j adatok bevitele, megl??v?? adat m??dos??t??sa ??s t??rl??se")
    public void SearchInputClearModifyData() {
        homePage.searchDataGeneral(oldSearchText);
        Assertions.assertEquals(oldSearchURL, driver.getCurrentUrl());
        String result = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals(oldSearchText, result);
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral(data));
        driver.findElement(SEARCH_RESULT).clear();
        String result2 = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals("", result2);
        driver.findElement(SEARCH_RESULT).sendKeys(newData);
        driver.findElement(BUTTON_SPAN).click();
        Assertions.assertEquals(newDataURL, driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingSearchedItemsGeneral(newSearchText));
    }
    @Test
    @DisplayName("TC25-Adatok lement??se fel??letr??l2")
    public void SaveToFile2() {
        FirstPage firstPage= new FirstPage(driver);
        firstPage.writeToAFile();
        TakeScreenshot2();
        Assertions.assertTrue(firstPage.writeToAFile().toString().contains(saveToFileText));
        Assertions.assertEquals(driver.findElement(searchedField).getText()+"\n",firstPage.writeToAFile().toString());
    }
    @Step("TakeScreenshot2")
    public void TakeScreenshot2(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}





