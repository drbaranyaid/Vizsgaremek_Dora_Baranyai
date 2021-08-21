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

    public final By LOGIN_BUTTON = By.xpath("//*[@id=\"pt-login\"]/a");
    private final By CREATE_ACCOUNT_BUTTON = By.xpath("//*[@id=\"pt-createaccount\"]/a");
    private final By PRIVACY_POLICY_BUTTON = By.xpath("//*[@id='footer-places-privacy']/a");
    private final By SEARCH_INPUT_FIELD = By.xpath("//*[@id='searchInput']");
    private final By SEARCH_BUTTON = By.xpath("//*[@id='searchButton']");
    public final By SEARCH_FIELD = (By.xpath("//*[@id=\"mw-content-text\"]/div[3]"));
    public String pathName ="src/main/resources/textForSearch.txt";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCreateAccountButton() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        new CreateAccountPage(driver);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        new FirstPage(driver);
    }

    public PrivacyPolicyPage clickPrivacyPolicyButton() {
        driver.findElement(PRIVACY_POLICY_BUTTON).click();
        return new PrivacyPolicyPage(driver);
    }


    public void searchDataGeneral(String data) {
        driver.findElement(SEARCH_INPUT_FIELD).sendKeys(data);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void searchData() {
        driver.findElement(SEARCH_BUTTON).click();
        new SearchResultPage(driver);
    }


    public void repeatedMultiInputSearch() {
        String[] dataItem;
        for (int i = 0; i < 8; i++) {
            try {
                File myfile = new File(pathName);
                Scanner scanner = new Scanner(myfile);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    dataItem = data.split(",");
                    driver.findElement(SEARCH_INPUT_FIELD).sendKeys(dataItem[i]);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean FindingSearchedItems() {
        List<WebElement> div = driver.findElements(SEARCH_FIELD);
        boolean isPresent = false;
        StringBuilder LinksText = new StringBuilder();
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            LinksText.append(link.getText());
            if (LinksText.toString().contains("tea")) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    public boolean FindingSearchedItemsGeneral(String data) {
        List<WebElement> div = driver.findElements(SEARCH_FIELD);
        boolean isPresent = false;
        StringBuilder LinksText = new StringBuilder();
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            LinksText.append(link.getText());
            if (LinksText.toString().contains(data)) {
                isPresent = true;
            }
        }
        return isPresent;
    }


}



