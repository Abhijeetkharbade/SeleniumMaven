package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //Full page screenshot
//        TakesScreenshot ts=(TakesScreenshot) driver;
//        File src=ts.getScreenshotAs(OutputType.FILE);
//        File trg=new File(".\\Screenshots\\homepage.png");
//        FileUtils.copyFile(src,trg);

        //Screenshot of portion of page
        WebElement ele= driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src=ele.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\Screenshots\\feature.png");
        FileUtils.copyFile(src,trg);

        driver.quit();
    }
}
