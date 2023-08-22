package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Provide First name,LastName,Email,Telephone,password,confirm password
and click privacy policy button.(isDisplayed and notSelected then click)
3-Click Continue Button
4-Validate message (Your Account Has Been Created!) -->if statement
5-Click Continue Button
6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
7-Close your browser
NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
 */

public class XpathPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName=driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Moldir");

        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Assylbekova");

        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("mo123456@gmail.com");

        WebElement telephone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("12345678");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("8888");

        WebElement passConfirm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passConfirm.sendKeys("8888");

        WebElement privacyButton=driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (privacyButton.isDisplayed() && !privacyButton.isSelected()){
            privacyButton.click();
        }
        WebElement submitButton=driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();


        WebElement header=driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']"));
        String actualHeader=header.getText();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)?"Validated":"Not Validated");

        WebElement continueButton= driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton.click();


        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualURL.equals(expectedURL)?"Passed":"FAILED");
        driver.close();




    }
}
