package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FirstPage {

    public WebDriver driver;
    private final By logoutButton = By.cssSelector("#pt-logout > a");
    public final By sandBoxButton = (By.xpath(("//*[@id=\"pt-sandbox\"]/a")));


    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
        new SpecialLogoutPage(driver);
    }

    public void clickSandBoxButton() {
        driver.findElement(sandBoxButton).click();
        new SandBoxPage(driver);
    }

    public StringBuilder writeToAFile() {
        try {
            FileWriter fileWriter = new FileWriter("SaveToFile.txt");
            fileWriter.append(driver.findElement(By.xpath("//*[@id='mp-itn']")).getText()).append("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("SaveToFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine()+"\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }


}




