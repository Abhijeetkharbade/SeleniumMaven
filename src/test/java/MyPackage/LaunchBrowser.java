package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhij\\OneDrive\\Desktop\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();  //Launch chrome driver

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhij\\Downloads\\Compressed\\geckodriver.exe");
//        WebDriver driver=new FirefoxDriver();  //Launch Firefox driver
//
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhij\\Downloads\\Compressed\\msedgedriver.exe");
//        WebDriver driver=new EdgeDriver();  //Launch Edge driver

        //Initiating Driver using WebDriverManager class
//        WebDriverManager.chromedriver().setup();  //For this we need to first write WebDrivermanager dependency from maven repository site. Then this line will setup any driver without u downloading or mentioning its location
//        WebDriver driver1=new ChromeDriver();

//        driver.get("https://www.opencart.com/index.php?route=account/register");
//        driver.get("https://www.amazon.in/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2F&ref_=footer_lang");
//        driver.get("https://demo.nopcommerce.com/");
//        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.get("https://www.onlinesbi.com/");
        driver.manage().window().maximize();
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

       // driver.navigate().to("https://www.google.in/");
        System.out.println("Title: "+driver.getTitle());  //To get title
        System.out.println("URL: "+driver.getCurrentUrl());  //To get URL of current page
//        System.out.println("HTML Page source: "+driver.getPageSource());  //To get HTML page source of current page

//        WebElement textBox=driver.findElement(By.xpath("//div[@id='nav-belt']//input[@id='twotabsearchtextbox']"));
//        WebElement engradio=driver.findElement(By.xpath("//div[@id='icp-language-settings']//input[@value='en_IN']"));
//        WebElement hndradio=driver.findElement(By.xpath("//div[@id='icp-language-settings']//input[@value='hi_IN']"));
//        WebElement ele=driver.findElement(By.xpath("//div[contains(@role,'presentation')]//a"));

//        List<WebElement>ele=driver.findElements(By.xpath("//div[contains(@role,'presentation')]//a"));
//
//        System.out.println("Is search displayed: "+textBox.isDisplayed());
//        System.out.println("Is search enabled: "+textBox.isEnabled());
//        System.out.println("Is English Selected: "+engradio.isSelected());
//        System.out.println("Is Hindi Selected: "+hndradio.isSelected());
//        ele.click();
//        for (WebElement foot:ele) {
//            System.out.println("Text: "+ele.getText());
//        }

//        WebElement search=driver.findElement(By.xpath("//select[@class='form-control']"));
//        search.sendKeys("WD");
//        System.out.println("If WD? ="+search.getAttribute("search"));
//        System.out.println("using get text"+search.getText());

//        search.click();
//        WebElement hindi=driver.findElement(By.xpath("//i[@text(),"));
//        hindi.click();

            //findElement Returns single/first element if xpath is pointing to multiple elements
//          WebElement el= driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
//          System.out.println(el.getText());
//
//          List<WebElement>ele=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
//          System.out.println(ele.size());
//          for (WebElement links:ele){
//              System.out.println(links.getText());
//          }

        //Selecting dropdown options using Select class
//            WebElement dropdownSelect = driver.findElement(By.xpath("//select[@name='country_id']"));
//            Select dropdown = new Select(dropdownSelect);
//            dropdown.selectByVisibleText("Argentina");
//            dropdown.selectByValue("10");  //selectByValue can be used only when value attribute is showing for dropdown in n/w tab
//            dropdown.selectByIndex(13);  //Index we need to assume and it will start from 0

            WebElement dropdown= driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-default']"));
            dropdown.click();

            List<WebElement> value=driver.findElements(By.xpath("//ul[@class='dropdown-menu inner']//li"));
        System.out.println(value.size());
        selectDropdown(value,"SARAL");


//        for (WebElement val:value) {
//            if (val.getText().equals("Corporate")){
//                val.click();
//                break;
//            }
//        }



            //Select a dropdown without using any methods
//             List<WebElement> countries=dropdown.getOptions();
//             for (WebElement option:countries){
//                 if (option.getText().equals("Argentina")){
//                     option.click();
//                     break;
//                 }
//             }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              driver.quit();


    }

    public static void selectDropdown(List<WebElement> value,String option){
        for (WebElement val:value) {
            if (val.getText().equals(option)){
                val.click();
                break;
            }
        }
    }
}
