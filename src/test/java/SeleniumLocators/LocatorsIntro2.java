package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/almat/Downloads/Techtorialhtml.html");

        //TAG NAME LOCATOR
        WebElement version= driver.findElement(By.tagName("u"));
        String actualVersion=version.getText();
        String expectedVersion="Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion)?"Passed":"Failed");

        //LINK TEXT LOCATOR
        WebElement javaLink= driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed":"Failed");

        //Task
        /*
    1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
    2-Go back to the main page
    3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
    4-Go back to the main page
    5-Click TestNG and validate(ternary) header -->TestNG
    6-Go back to the main page
    7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
        */
        //Selenium
        driver.navigate().back();
        WebElement seleniumLink= driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement header1=driver.findElement(By.tagName("h1"));
        String actualHeader1=header1.getText();
        String expectedHeader1="Selenium automates browsers. That's it!";
        System.out.println(actualHeader1.equals(expectedHeader1)?"Passed1":"Failed1");

        //Cucumber
        driver.navigate().back();
        WebElement CucumberLink= driver.findElement(By.linkText("Cucumber"));
        CucumberLink.click();
        WebElement header2=driver.findElement(By.tagName("h1"));
        String actualHeader2=header2.getText();
        String expectedHeader2="Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader2.equals(expectedHeader2)?"Passed2":"Failed2");

        //TestNG
        driver.navigate().back();
        WebElement testNgLink= driver.findElement(By.linkText("TestNG"));
        testNgLink.click();
        WebElement header3=driver.findElement(By.tagName("h2"));
        String actualHeader3=header3.getText();
        String expectedHeader3="TestNG";
        System.out.println(actualHeader3.equals(expectedHeader3)? "Passed3":"Failed3");

        //Validating main page URL
        driver.navigate().back();
        //System.out.println(driver.getCurrentUrl());
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="file:///Users/almat/Downloads/Techtorialhtml.html";
        System.out.println(actualUrl.equals(expectedUrl)?"ValidatedURL":"NotValidatedURL");

        //PARTIAL LINK TEXT:

        WebElement rest_api= driver.findElement(By.partialLinkText("Rest"));
        rest_api.click();
        System.out.println(driver.getTitle());
        driver.close();


    }
}
