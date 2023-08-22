package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {
    @Test
    public void getTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");
        System.out.println(driver.getTitle()+" This is from Driver Method");
       // JavascriptExecutor js=(JavascriptExecutor) driver;
        //System.out.println(js.executeScript("return document.title") +" with JS");
        System.out.println( BrowserUtils.getTitleWithJS(driver));
    }
    @Test
    public void ClickJs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");
        WebElement aboutUSbutton= driver.findElement(By.xpath("//button[.='About us']"));
        aboutUSbutton.click();
        driver.navigate().back();
        Actions actions=new Actions(driver);
        actions.click(aboutUSbutton).perform();
        driver.navigate().back();
        Thread.sleep(5000);
        //If none of them work please us js click
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//       js.executeScript("arguments[0].click()", aboutUSbutton);
        BrowserUtils.clickWithJS(driver, aboutUSbutton);
    }
    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codefish.io/");

        //WebElement cookies=driver.findElement(By.xpath("//button[@id='psGotItBtn']"));
        //cookies.click();
        WebElement address= driver.findElement(By.xpath("//p[contains(text(), '2200')]"));
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", address);
        Thread.sleep(2000);
        BrowserUtils.scrollIntoView(driver, address);
        System.out.println(BrowserUtils.getText(address));

        WebElement contactUs=driver.findElement(By.xpath("//button[.='Contact Us']"));
       // js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        Thread.sleep(2000);
        BrowserUtils.scrollIntoView(driver, contactUs);

    }
}
