package searchResultPage;

import org.junit.jupiter.api.DisplayName;
import pages.HomePage;
import pages.SearchResultPage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;



public class SearchResultPageTest extends BaseTest {

    private final By NEXT_20 = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By RESULT_FIELD = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]");
    private final By RES_DIV = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li/div/a");
    private final By DIV4 = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/ul/li/div/a");
    public String font = "Font types";
    public String next20 = "next 20";
    public String prev = "previous 20";
    public String fontText = "font";
    public String tea = "green tea";
    public String daihatsu = "Daihatsu types";
    public String daihatsuText = "Daihatsu";
    public String fiat = "Polski Fiat types";


    public String resultFont = "List of typefaces\n" +
            "Typeface\n" +
            "Computer font\n" +
            "PostScript fonts\n" +
            "Font\n" +
            "TrueType\n" +
            "OpenType\n" +
            "Unicode font\n" +
            "Web Open Font Format\n" +
            "Embedded OpenType\n" +
            "Variable font\n" +
            "Type\n" +
            "Font Awesome\n" +
            "Calibri\n" +
            "Wonton font\n" +
            "Google Fonts\n" +
            "ClearType\n" +
            "Serif\n" +
            "Liberation fonts\n" +
            "Baptismal font\n" +
            "List of typefaces\n" +
            "Typeface\n" +
            "Computer font\n" +
            "PostScript fonts\n" +
            "Font\n" +
            "TrueType\n" +
            "OpenType\n" +
            "Unicode font\n" +
            "Web Open Font Format\n" +
            "Embedded OpenType\n" +
            "Variable font\n" +
            "Type\n" +
            "Font Awesome\n" +
            "Calibri\n" +
            "Wonton font\n" +
            "Google Fonts\n" +
            "ClearType\n" +
            "Serif\n" +
            "Liberation fonts\n" +
            "Baptismal font\n" +
            "Italic type\n" +
            "Consolas\n" +
            "Cambria (typeface)\n" +
            "Monospaced font\n" +
            "Bitstream Speedo Fonts\n" +
            "Emphasis (typography)\n" +
            "Fallback font\n" +
            "Georgia (typeface)\n" +
            "Doves Press\n" +
            "Oblique type\n" +
            "Type foundry\n" +
            "Lucida\n" +
            "Computer Modern\n" +
            "Baptismal font\n" +
            "Web typography\n" +
            "Fonts on Macintosh\n" +
            "Adobe Fonts\n" +
            "Constantia (typeface)\n" +
            "List of type designers\n" +
            "Candara";

    String resultDaihatsu = "Daihatsu\n" +
            "Daihatsu Move\n" +
            "Daihatsu Copen\n" +
            "Daihatsu Terios\n" +
            "Astra Daihatsu Motor\n" +
            "Daihatsu Midget\n" +
            "Daihatsu Mira\n" +
            "Daihatsu Rugger\n" +
            "Daihatsu Tanto\n" +
            "Daihatsu Charade\n" +
            "Daihatsu E-series engine\n" +
            "Daihatsu Charmant\n" +
            "Daihatsu Hijet\n" +
            "Daihatsu Boon\n" +
            "Toyota SZ engine\n" +
            "Toyota Avanza\n" +
            "Daihatsu Cast\n" +
            "Daihatsu New Global Architecture\n" +
            "Daihatsu Sigra\n" +
            "Daihatsu Move Canbus\n" +
            "Daihatsu Ayla\n" +
            "Daihatsu Rocky (A200)\n" +
            "Daihatsu Wake\n" +
            "Toyota bB\n" +
            "Daihatsu K-series engine\n" +
            "Daihatsu Esse\n" +
            "Daihatsu Thor\n" +
            "Daihatsu-class landing craft\n" +
            "Subaru\n" +
            "Daihatsu C-series engine\n" +
            "Daihatsu J-series engine\n" +
            "List of Subaru vehicles\n" +
            "List of Toyota vehicles\n" +
            "Perodua Myvi\n" +
            "Daihatsu H-series engine\n" +
            "Daihatsu Compagno\n" +
            "Toyota KR engine\n" +
            "Daihatsu Mira e:S\n" +
            "Toku Daihatsu-class landing craft\n" +
            "Daihatsu Gran Max\n";

    String resultFiat = "Fiat 126\n" +
            "Fiat 1300 and 1500\n" +
            "Fiat Seicento\n" +
            "Fiat 500\n" +
            "Fiat 127\n" +
            "Fiat 518\n" +
            "Fiat S.p.A.\n" +
            "Fiat Panda\n" +
            "FSO Polonez\n" +
            "Fiat 131\n" +
            "Fiat 524\n" +
            "Fabryka Samochodów Osobowych\n" +
            "Fiat Twin Cam engine\n" +
            "Nasr (car company)\n" +
            "Fiat 508\n" +
            "Compañía Colombiana Automotriz\n" +
            "List of rally cars\n" +
            "TKS\n" +
            "Ursus A\n" +
            "List of World War II weapons of Poland\n" +
            "Fiat 126\n" +
            "Fiat 1300 and 1500\n" +
            "Fiat Seicento\n" +
            "Fiat 500\n" +
            "Fiat 127\n" +
            "Fiat 518\n" +
            "Fiat S.p.A.\n" +
            "Fiat Panda\n" +
            "FSO Polonez\n" +
            "Fiat 131\n" +
            "Fiat 524\n" +
            "Fabryka Samochodów Osobowych\n" +
            "Fiat Twin Cam engine\n" +
            "Nasr (car company)\n" +
            "Fiat 508\n" +
            "Compañía Colombiana Automotriz\n" +
            "List of rally cars\n" +
            "TKS\n" +
            "Ursus A\n" +
            "List of World War II weapons of Poland\n" +
            "Fiat 126\n" +
            "Fiat 1300 and 1500\n" +
            "Fiat Seicento\n" +
            "Fiat 500\n" +
            "Fiat 127\n" +
            "Fiat 518\n" +
            "Fiat S.p.A.\n" +
            "Fiat Panda\n" +
            "FSO Polonez\n" +
            "Fiat 131\n" +
            "Fiat 524\n" +
            "Fabryka Samochodów Osobowych\n" +
            "Fiat Twin Cam engine\n" +
            "Nasr (car company)\n" +
            "Fiat 508\n" +
            "Compañía Colombiana Automotriz\n" +
            "List of rally cars\n" +
            "TKS\n" +
            "Ursus A\n" +
            "List of World War II weapons of Poland\n";


    @Test
    @DisplayName("TC21-Search/több oldalas lista bejárása/full list check")
    public void SearchPagesListCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchDataGeneral(font);
        String linkText = searchResultPage.SearchPagesGeneral(RES_DIV);
        searchResultPage.ClickNext();
        String linkText2 = linkText + searchResultPage.SearchPagesGeneral(RES_DIV);
        Assertions.assertEquals(resultFont, linkText2);
    }

    @Test
    @DisplayName("TC22-Search/több oldalas lista bejárása/page check")
    public void SearchMorePagesTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral(font);
        Assertions.assertEquals(font, driver.findElement(RESULT_FIELD).getText());
        Assertions.assertEquals(next20, driver.findElement(NEXT_20).getText());
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.ClickNext();
        Assertions.assertEquals(font, driver.findElement(RESULT_FIELD).getText());
        Assertions.assertEquals(prev, driver.findElement(NEXT_20).getText());
    }


    @Test
    @DisplayName("TC23-Search/több oldalas lista bejárása/contains")
    public void SearchPagesContainsCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchDataGeneral(font);
        String linktext = searchResultPage.SearchPagesGeneral(RES_DIV);
        searchResultPage.ClickNext();
        String linktext2 = linktext + searchResultPage.SearchPagesGeneral(RES_DIV);
        Assertions.assertTrue(linktext2.contains(fontText));
    }
    @Test
    @DisplayName("TC16-Search/adatok listázása/link szöveg ellenőrzéssel")
    public void SearchOnePageResultCheck() {
        homePage.searchDataGeneral(font);
        Assertions.assertEquals(font, driver.findElement(RESULT_FIELD).getText());
        Assertions.assertEquals(next20, driver.findElement(NEXT_20).getText());
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.SearchPagesGeneral(RES_DIV).contains(fontText));
    }


    @Test
    @DisplayName("TC17-Search/adatok listázása/teljes oldalbejárással")
    public void testDataList() {
        homePage.searchDataGeneral(tea);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.GreenTeaCheck());
    }

    @Test
    @DisplayName("TC18-Search/adatok listázása/teljes oldalbejárással/találatok száma")
    public void testDataListNumber() {
        homePage.searchDataGeneral(tea);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(193, searchResultPage.GreenTeaCheckNumber());

    }

    @Test
    @DisplayName("TC19-Search/több oldalas lista bejárása/contains")
    public void SearchPagesTestSearchFieldShortDataTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral(daihatsu);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.SearchPagesGeneral(RES_DIV).contains(daihatsuText));
        searchResultPage.ClickNext();
        Assertions.assertTrue(searchResultPage.SearchPagesGeneral(RES_DIV).contains(daihatsuText));
    }

    @Test
    @DisplayName("TC20-Search/több oldalas lista bejárása/full list check")
    public void SearchPagesTestListCheck2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral(daihatsu);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.SearchPagesGeneral(RES_DIV);
        searchResultPage.ClickNext();
        Assertions.assertEquals(resultDaihatsu, searchResultPage.SearchPagesGeneral(RES_DIV));
    }

    @Test
    @DisplayName("TC27-Search/több oldalas lista összes oldala bejárása/full list check")
    public void SearchAllPagesCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral(fiat);
        SearchResultPage searchResultPage= new SearchResultPage(driver);
        String linkText=searchResultPage.SearchPagesGeneral(DIV4);
        searchResultPage.ClickNextFiat();
        String linkText2= linkText+searchResultPage.SearchPagesGeneral(DIV4);
        searchResultPage.ClickNext2Fiat();
        String linkText3= linkText2+searchResultPage.SearchPagesGeneral(DIV4  );
        Assertions.assertEquals(resultFiat, linkText3);
    }


}

