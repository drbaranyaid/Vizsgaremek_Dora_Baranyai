package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FirstPage {

    public WebDriver driver;
    private final By LOGOUT_BUTTON = By.cssSelector("#pt-logout > a");
    public final By SAND_BOX_BUTTON = (By.xpath(("//*[@id=\"pt-sandbox\"]/a")));
    public final By IN_THE_NEWS = (By.xpath("//*[@id='mp-itn']"));
    public String file = "SaveToFile.txt";



    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
        new SpecialLogoutPage(driver);
    }

    public void clickSandBoxButton() {
        driver.findElement(SAND_BOX_BUTTON).click();
        new SandBoxPage(driver);
    }

    public StringBuilder writeToAFile() {
        WebElement news = driver.findElement(IN_THE_NEWS);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(news.getText()).append("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("SaveToFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }


}




