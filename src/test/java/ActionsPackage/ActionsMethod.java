package ActionsPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethod {

    @Test
    public void contextClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement box= driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.contextClick(box).perform();
    }
    @Test
    public void practiceContectClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement box= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Thread.sleep(1000);
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();
    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick=driver.findElement(By.xpath("//button[contains(text(), 'Double-Click Me To See Alert')]"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClick).perform();
    }
}
