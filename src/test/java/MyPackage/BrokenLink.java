package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLink {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> link = driver.findElements(By.tagName("a"));

        int emptyURL = 0;
        int brokenLink=0;
        int validLink=0;
        for (WebElement list : link) {
            String url = list.getAttribute("href");
            //URL ele=new URL(url);
            if (url == null || url.isEmpty()) {
                emptyURL++;
                System.out.println(url+" URL is empty");
               // continue;
            }

            URL add = new URL(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) add.openConnection();
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                    System.out.println(conn.getResponseCode() + " Is broken link");
                    brokenLink++;
                }
                else {
                    System.out.println(conn.getResponseCode()+" Is normal link");
                    validLink++;
                }
            } catch (Exception e) {

            }


        }
        System.out.println("No of broken links "+brokenLink);
        System.out.println("No of empty links "+emptyURL);
        System.out.println("No of valid links "+validLink);
    }
}
