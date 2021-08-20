package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {
    private final WebDriver driver;

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public final By presentPolicy = (By.xpath("//*[@id=\"mw-content-text\"]/div[1]/p[7]"));
    public final By summary = (By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[3]/div"));

    public String getTextFromPolicy(){
        String text= driver.findElement(presentPolicy).getText();
        return text;
    }

    public String getTextFromSummary(){
        String textSummary= driver.findElement(summary).getText();
        return textSummary;
    }
}
