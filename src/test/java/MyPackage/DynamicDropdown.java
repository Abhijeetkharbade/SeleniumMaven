package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.co.in/");
        WebElement search=driver.findElement(By.xpath("//input[@title='Search']"));
        search.sendKeys("Selenium");
        List<WebElement> dropdownResult=driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
        System.out.println(dropdownResult.size());
        for (WebElement result: dropdownResult) {
            if (result.getText().equals("selenium")) {
                result.click();
                break;
            }
        }
    }
}
