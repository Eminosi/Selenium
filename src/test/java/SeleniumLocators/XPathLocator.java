package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement abTest= driver.findElement(By.partialLinkText("Testing"));
        abTest.click();
        //Absolute xpath (because of single slash and html)
        WebElement header= driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());
        //Relative xpath
        WebElement header1= driver.findElement(By.xpath("//a[contains(text(), 'Elemental')]"));
        header1.click();
        System.out.println(header1.getText());

    }
}

