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

public class DragAndDrop {
    @Test
    public void dragAndDropMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxText= BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxText="... Or here.";
        Assert.assertEquals(actualOrangeBoxText, expectedOrangeBoxText);
        String actualOrangeBoxColor=orangeBox.getCssValue("background-color");
        String expectedOrangeBoxColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualOrangeBoxColor,expectedOrangeBoxColor);
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(1000);
        orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        actualOrangeBoxText=BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxNewText="You did great!";
        Assert.assertEquals(actualOrangeBoxText, expectedOrangeBoxNewText);
    }
    @Test
    public void dragAndDropBlue() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxText=BrowserUtils.getText(blueBox);
        String expectedBlueBoxText="Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText);
        String actualBlueColor=blueBox.getCssValue("background-color");
        String expectedBlueColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueColor, expectedBlueColor);
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.scrollByAmount(300, 300).perform();
        Thread.sleep(1000);
       // actions.dragAndDrop(draggable,blueBox).perform();
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        actualBlueBoxText=BrowserUtils.getText(blueBox);
        String expectedBlueTextAfter="You did great!";
        Assert.assertEquals(actualBlueBoxText, expectedBlueTextAfter);

    }
}
