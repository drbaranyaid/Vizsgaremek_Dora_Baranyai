package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPage {

    public WebDriver driver;
    public final By TEXT_FIELD = By.xpath("//*[@id=\"wpTextbox1\"]");
    public final By PREVIEW = By.xpath("//*[@id=\"wpPreview\"]");
    public String path = "src/main/resources/notes.txt";

    public SandBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void textFieldClear() {
        driver.findElement(TEXT_FIELD).clear();
    }

    public void textFieldSendData(String text) {
        driver.findElement(TEXT_FIELD).sendKeys(text);
    }

    public void clickShowPreviewButton() {
        driver.findElement(PREVIEW).click();
    }

    public void textFieldClick() {
        driver.findElement(TEXT_FIELD).click();
    }

    public void repeatedMultiInput() {
        for (int j = 0; j < 9; j++) {
            try {
                File myfile = new File(path);
                Scanner scanner = new Scanner(myfile);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    System.out.println();
                    driver.findElement(TEXT_FIELD).sendKeys(data + " ");

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
        utils.setWait(PREVIEW);
        clickShowPreviewButton();
        utils.setWait(TEXT_FIELD);


    }



}
