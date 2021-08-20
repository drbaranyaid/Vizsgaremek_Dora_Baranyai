package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class HomePage {

    private final WebDriver driver;

    public final By loginButton = By.xpath("//*[@id=\"pt-login\"]/a");
    private final By createAccountButton = By.xpath("//*[@id=\"pt-createaccount\"]/a");
    private final By privacyPolicyButton = By.xpath("//*[@id='footer-places-privacy']/a");
    private final By SearchInputField = By.xpath("//*[@id='searchInput']");
    private final By SearchButton = By.xpath("//*[@id='searchButton']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
        new CreateAccountPage(driver);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        new FirstPage(driver);
    }

    public PrivacyPolicyPage clickPrivacyPolicyButton() {
        driver.findElement(privacyPolicyButton).click();
        return new PrivacyPolicyPage(driver);
    }


    public void searchDataGeneral(String data) {
        driver.findElement(SearchInputField).sendKeys(data);
        driver.findElement(SearchButton).click();
    }

    public void searchData() {
        driver.findElement(SearchButton).click();
        new SearchResultPage(driver);
    }


    public void repeatedMultiInputSearch() {
        String[] dataItem;
        for (int i = 0; i < 8; i++) {
            try {
                File myfile = new File("src/main/resources/textForSearch.txt");
                Scanner scanner = new Scanner(myfile);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    dataItem = data.split(",");
                    driver.findElement(SearchInputField).sendKeys(dataItem[i]);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean FindingSearchedItems() {
        List<WebElement> div = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[3]"));
        boolean isPresent = false;
        String LinksText = "";
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            LinksText += (link.getText());
            if (LinksText.contains("tea")) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    public boolean FindingSearchedItemsGeneral(String data) {
        List<WebElement> div = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[3]"));
        boolean isPresent = false;
        String LinksText = "";
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            LinksText += (link.getText());
            if (LinksText.contains(data)) {
                isPresent = true;
            }
        }
        return isPresent;
    }


}



