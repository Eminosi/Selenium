package ActionsPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void practiceDragAndDrug() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement box= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualBoxText= BrowserUtils.getText(box);
        String expectedBoxText="Drop here";
        Assert.assertEquals(actualBoxText, expectedBoxText);

        Thread.sleep(1000);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,box).perform();
        //box= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualBoxTextAfter= BrowserUtils.getText(box);
        String expectedTextAfter="Dropped!";
        Assert.assertEquals(actualBoxTextAfter, expectedTextAfter);
        String actualColor=box.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);
    }
    @Test
    public void clickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        //find the location of accept button and click it
        Thread.sleep(1000);
        WebElement acceptButton= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        Actions actions=new Actions(driver);
        actions.click(acceptButton).perform();
        //check the text in box before, validate
        Thread.sleep(1000);
        WebElement box= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Thread.sleep(3000);
        String actualBoxText= BrowserUtils.getText(box);
        String expectedBoxText="Drop here";
        Assert.assertEquals(actualBoxText, expectedBoxText);
        //find not acceptable element
        WebElement notAcceptableElement= driver.findElement(By.cssSelector("#notAcceptable"));
        //drop not acceptable
        actions.clickAndHold(notAcceptableElement).moveToElement(box).release().perform();
        // validate the text again
        box= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        actualBoxText= BrowserUtils.getText(box);
        String expectedTestAfter="Drop here";
        Assert.assertEquals(actualBoxText,expectedTestAfter);
    }
}
