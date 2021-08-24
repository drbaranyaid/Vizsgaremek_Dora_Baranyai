package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By NEXT_20 = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By RES_DIV = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li/div/a");
    private final By DIV4 = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/ul/li/div/a");
    private final By NEXT_FIAT = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/p[2]/a[1]");
    private final By NEXT_FIAT2 = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]");

    private String result = "";
    private final String TEA_DATA = "Green tea";

    List<WebElement> div = new ArrayList<>();


    public <BY> String SearchPagesGeneral(BY data) {
        String linktext;
        div = driver.findElements((By) data);
        for (WebElement webElement : div) {
            linktext = webElement.getText();
            result += linktext + "\n";
        }
        return result;
    }

    public void ClickNext() {
        Utils.scrollDown(driver);
        driver.findElement(NEXT_20).click();
    }

    public void ClickNextFiat() {
        Utils.scrollDown(driver);
        driver.findElement(NEXT_FIAT).click();
    }

    public void ClickNext2Fiat() {
        Utils.scrollDown(driver);
        driver.findElement(NEXT_FIAT2).click();
    }

    public boolean GreenTeaCheck() {
        boolean isTestDataList = false;
        List<WebElement> elements = driver.findElements(By.xpath("//*"));
        for (WebElement element : elements) {
            try {
                if (element.getText().toLowerCase().contains(TEA_DATA.toLowerCase())) {
                    System.out.println(element.getText());
                    isTestDataList = true;
                }
            } catch (Exception ignored) {
            }
        }
        return isTestDataList;
    }

    public int GreenTeaCheckNumber() {
        int number = 0;
        List<WebElement> words = driver.findElements(By.xpath("//*"));
        for (WebElement element : words) {
            try {
                if (element.getText().toLowerCase().contains(TEA_DATA.toLowerCase())) {
                    System.out.println(element.getText());
                    number += 1;
                }
            } catch (Exception ignored) {
            }
        }
        System.out.println(number);
        return number;
    }
}


