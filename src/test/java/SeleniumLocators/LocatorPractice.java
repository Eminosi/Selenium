package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
    /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        WebElement name=driver.findElement(By.name("firstname"));
        name.sendKeys("Molly");


        WebElement lastName=driver.findElement(By.name("lastname"));
                lastName.sendKeys("Assylbekova");

        Thread.sleep(3000);
        WebElement gender=driver.findElement(By.id("sex-1"));
        gender.click();


        WebElement experience=driver.findElement(By.id("exp-5"));
        experience.click();


        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("08/08/2023");


        WebElement prof=driver.findElement(By.id("profession-0"));
        prof.click();


        WebElement prof1=driver.findElement(By.id("profession-1"));
        prof1.click();


        WebElement tool=driver.findElement(By.id("tool-2"));
        tool.click();


        WebElement continent=driver.findElement(By.id("continents"));
        continent.sendKeys("Asia");


        WebElement button=driver.findElement(By.id("submit"));
        button.click();


        String actualURL= driver.getCurrentUrl();
        String expectedURl="https://www.techlistic.com/p/selenium-practice-form.html";
       System.out.println(actualURL.equals(expectedURl)?"Passed":"Failed");
       driver.close();




    }
}
