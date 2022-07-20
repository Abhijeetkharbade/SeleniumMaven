package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Waits {
    public static void main(String[] args) {
        //Most of the Time automation scripts are faster than application responds that's why scripts fails
        // coz element still not enabled….
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Implicit wait is a global wait we can add after initialization of chrome driver,
        // whenever any element takes time to enable it will wait for specified time before failing script
        // and throwing exception.
        //Disadvantage is the value is hardcoded if any element takes more time then script will fail.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        try {int[] a={1,2,3,};
            System.out.println(a[10]);
        }
        catch (Exception e){
            System.out.println("something went wrong");
        }
        finally {
            System.out.println("The 'try catch' is finished.");
        }
    }
}
