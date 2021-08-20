package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPage {

    public WebDriver driver;
    public final By textfield = By.xpath("//*[@id=\"wpTextbox1\"]");
    public final By preview = By.xpath("//*[@id=\"wpPreview\"]");

    public SandBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void textFieldClear() {
        driver.findElement(textfield).clear();
    }

    public void textFieldSendData(String text) {
        driver.findElement(textfield).sendKeys(text);
    }

    public void clickShowPreviewButton() {
        driver.findElement(preview).click();
    }

    public void textFieldClick() {
        driver.findElement(textfield).click();
    }

    public void repeatedMultiInput() {
        for (int j = 0; j < 9; j++) {
            try {
                File myfile = new File("src/main/resources/notes.txt");
                Scanner scanner = new Scanner(myfile);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    System.out.println();
                    driver.findElement(textfield).sendKeys(data + " ");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Utils utils = new Utils(driver);
        utils.setWait(preview);
        clickShowPreviewButton();
        utils.setWait(textfield);


    }



}
