package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxSelection {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        //WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));

        //Using for loop
//        for (int i=0;i<checkbox.size();i++){
//                checkbox.get(i).click();
//        }

        //Using for each loop
//        for (WebElement check:checkbox)
//        {
//            check.click();
//        }

        //Selecting specific checkbox
//        for (WebElement check:checkbox)
//        {
//         String day=check.getAttribute("id");
//         if (day.equals("monday")||day.equals("friday")){
//             check.click();
//         }
//        }

        //Select last 2 checkbox
//        for (int i=checkbox.size()-1;i> checkbox.size()-3;i--){
//            checkbox.get(i).click();
//        }

        //Select first 2 checkbox
        for (int i=0;i<2;i++){
            checkbox.get(i).click();
        }
    }
}
