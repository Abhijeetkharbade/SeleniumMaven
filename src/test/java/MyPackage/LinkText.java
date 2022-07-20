package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        //driver.findElement(By.linkText("Today's Deals")).click(); //Need to give full text
        //driver.findElement(By.partialLinkText("Deals")).click(); //Can give partial text, make sure there is only 1 Deals text

        //Capture all links in a web page
        List<WebElement> links= driver.findElements(By.tagName("a"));
//        for (int i=0;i<links.size();i++)
//        {
//            System.out.println(links.get(i).getText());
//            System.out.println(links.get(i).getAttribute("href"));
//
//        }

        //Using for each loop
        for (WebElement List :links)
        {
            System.out.println(List.getText());
            System.out.println(List.getAttribute("href"));
        }


    }
}
