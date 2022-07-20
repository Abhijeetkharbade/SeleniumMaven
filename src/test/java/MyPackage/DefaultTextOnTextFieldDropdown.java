package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DefaultTextOnTextFieldDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.twoplugs.com/");
        driver.findElement(By.xpath("//a[@href=\"/newsearchserviceneed\"]")).click();

        WebElement search=driver.findElement(By.xpath("//input[@id='autocomplete']"));
        search.clear();
        search.sendKeys("Toronto");

        String text;
        do{search.sendKeys(Keys.ARROW_DOWN);
        text=search.getAttribute("value");
        if (text.equals("Toronto, OH, USA")){
            search.sendKeys(Keys.ENTER);
            break;

        }
            Thread.sleep(3000);
        }
        while (!text.isEmpty());
    }
}
