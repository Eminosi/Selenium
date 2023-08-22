package Seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExample {
    /*
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            4. Close browser.
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String actualTitle= driver.getTitle();
        String actualURL= driver.getCurrentUrl();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        String expectedUrl="https://www.godaddy.com/";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("FAIL");
        }
        if (actualURL.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


    }
}
