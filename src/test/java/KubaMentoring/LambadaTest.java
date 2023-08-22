package KubaMentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LambadaTest {
    /*
Navigate to lambdaTest web https://www.lambdatest.com/selenium-playground/
click on Input Form Submit
Once clicked, fill in the input fields, and click submit button
And finally, verify the success message with assert

 */
    @Test
    public void TC_01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(.,'Input')]")).click();
        WebElement firstName= driver.findElement(By.cssSelector("#name"));
        firstName.sendKeys("Molly");
        WebElement emailAddress= driver.findElement(By.cssSelector("#inputEmail4"));
        emailAddress.sendKeys("mo@com");
        WebElement passwordField=driver.findElement(By.cssSelector("#inputPassword4"));
        passwordField.sendKeys("12345");
        WebElement companyField=driver.findElement(By.cssSelector("#company"));
        companyField.sendKeys("Apple");
        WebElement website=driver.findElement(By.cssSelector("websitename"));
        website.sendKeys("apple.com");
        WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");



    }
}
