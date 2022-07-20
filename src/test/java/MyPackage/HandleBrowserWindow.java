package MyPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindow {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();

        //Getting single Window ID using windowHandle
        String id= driver.getWindowHandle();
        System.out.println(id);

        //Getting multiple window ids using getWindowHandles using Iterator method
        Set<String> ids=driver.getWindowHandles();  //SET collection allows duplicates

//        Iterator<String> idss= ids.iterator();
//        System.out.println("Parent"+idss.next());
//        System.out.println("Child"+idss.next());

        //Getting multiple window ids using getWindowHandles using ArrayList
//        List<String> idss=new ArrayList<>(ids);  //Converting Set to List
//        String parent = idss.get(0);
//        String child = idss.get(1);
//        System.out.println("Parent "+parent+"\n"+"Child "+child);

        //When new tab opened our driver will still focus on 1st window, we cannot perform operation in child window.
        //That's why we need window id to perform operation in specified window

        //How to use window ids to switch tab
//        driver.switchTo().window(parent);
//        System.out.println("parent title"+driver.getTitle());
//        driver.switchTo().window(child);
//        System.out.println("child title"+driver.getTitle());

        //Using forEach loop to get all ids at once
        for (String idss:ids) {
            System.out.println(idss);
            System.out.println(driver.switchTo().window(idss).getTitle());
        }
//        driver.close();//Will close the window whichever driver is pointing
//        driver.quit();//Will close all the driver windows

        //Close perticuler window
        for (String idss:ids) {
            String title=driver.switchTo().window(idss).getTitle();
            if(title.equals("OrangeHRM")){
                driver.close();
            }
        }
    }
}
