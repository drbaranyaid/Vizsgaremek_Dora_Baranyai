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

    private final By Next20 = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By RES_DIV = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li/div/a");
    private String result = "";

    List<WebElement> div = new ArrayList<>();


    public String SearchPages() {
        String linktext = "";
        div = driver.findElements(RES_DIV);
        for (WebElement webElement : div) {
            linktext = webElement.getText();
            //System.out.println(linktext);
            result += linktext + "\n";
        }
        //System.out.println(result);
        return result;
    }
    public String  SearchPagesFiat() {
        String linktext = "";
        div = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[4]/ul/li/div/a"));
        for (WebElement webElement : div) {
            linktext = webElement.getText();
            //System.out.println(linktext);
            result += linktext + "\n";
        }
        //System.out.println(result);
        return result;
    }

    public void ClickNext() {
        Utils.scrollDown(driver);
        driver.findElement(Next20).click();
    }

    public void ClickNextFiat() {
        Utils.scrollDown(driver);
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[4]/p[2]/a[1]")).click();
    }

    public void ClickNext2Fiat() {
        Utils.scrollDown(driver);
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).click();
    }

    public boolean GreenTeaCheck() {
        boolean isTestDataList = false;
        List<WebElement> elements = driver.findElements(By.xpath("//*"));
        for (WebElement element : elements) {
            try {
                if (element.getText().toLowerCase().contains("Green tea".toLowerCase())) {
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
                if (element.getText().toLowerCase().contains("Green tea".toLowerCase())) {
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


