package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class SelectBasicPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/almat/Downloads/Techtorialhtml.html");
        WebElement country= driver.findElement(By.xpath("//select[@name='country']"));
        Select countrySelect=new Select(country);

        String actualText=countrySelect.getFirstSelectedOption().getText();
        String expectedText="UNITED STATES";
        Assert.assertEquals(actualText,expectedText);
        List<WebElement> allCountries=countrySelect.getOptions();
        int count=0;
        for (WebElement c:allCountries){
            System.out.println(c.getText().trim());
            count++;
        }
        System.out.println(count);
        //Task:Choose your own country with visible text method

        countrySelect.selectByVisibleText("KAZAKHSTAN");
        Thread.sleep(2000);
        countrySelect.selectByValue("200");
        Thread.sleep(2000);
        countrySelect.selectByIndex(5);

    }
}
