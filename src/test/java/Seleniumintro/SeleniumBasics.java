package Seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class SeleniumBasics {
    public static void main(String[] args) {
        //First STEP: Setting up automation
        WebDriverManager.chromedriver().setup();

        //SECOND STEP: Creating driver to make connection with website
        WebDriver driver=new ChromeDriver();

        //THIRD STEP: Navigating to the website
        driver.get("https://www.amazon.com/");

        System.out.println(driver.getTitle());
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is passed");
        }else {
            System.out.println("Title is Failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL is passed");
        }else{
            System.out.println("URL is failed");
        }
        //HOMEWORK:
        /*
        Go to 3 different website and validate TITLE and URL
         */
        //YOUTUBE
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        String actualTitle1=driver.getTitle();
        String expectedTitle1="YouTube";
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Youtube title Passed");
        }else{
            System.out.println("Youtube title Failed");
        }
        String actualUrl1=driver.getCurrentUrl();
        String expectedUrl1="https://www.youtube.com/";
        if (actualUrl1.equals(expectedUrl1)){
            System.out.println("Youtube Url passed");
        }else {
            System.out.println("Youtube URL failed");
        }
        //Apple
        driver.get("https://www.apple.com/");
        System.out.println(driver.getTitle());
        String actualTitle2=driver.getTitle();
        String expectedTitle2="Apple";
        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Apple title Passed");
        }else{
            System.out.println("Apple title Failed");
        }
        String actualUrl2=driver.getCurrentUrl();
        String expectedUrl2="https://www.apple.com/";
        if (actualUrl2.equals(expectedUrl2)){
            System.out.println("Apple Url passed");
        }else {
            System.out.println("Apple URL failed");
        }
        //Hermes
        driver.get("https://www.hermes.com/us/en/");
        System.out.println(driver.getTitle());
        String actualTitle3=driver.getTitle();
        String expectedTitle3="The official Hermès online store | Hermès USA";
        if (actualTitle3.equals(expectedTitle3)){
            System.out.println("Hermes title Passed");
        }else{
            System.out.println("Hermes title Failed");
        }
        String actualUrl3=driver.getCurrentUrl();
        String expectedUrl3="https://www.hermes.com/us/en/";
        if (actualUrl3.equals(expectedUrl3)){
            System.out.println("Hermes Url passed");
        }else {
            System.out.println("Hermes URL failed");
        }
        driver.close();


    }
}
