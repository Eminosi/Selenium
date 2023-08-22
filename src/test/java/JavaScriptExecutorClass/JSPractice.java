package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.cssSelector("#yesRadio"));
        //yesButton.click();//doesn't work
        Actions actions=new Actions(driver);
        //actions.click(yesButton); doesn't work
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);
        String expectedYes="You have selected Yes";
        WebElement YesText= driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(YesText).trim(), expectedYes);

        WebElement impressive= driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressive);
        String expectedImpressive="You have selected Impressive";
        WebElement impressiveText= driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(BrowserUtils.getText(impressiveText).trim(), expectedImpressive);

        WebElement noButton= driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noButton.isEnabled());


    }
    @Test
    public void practiceAllJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //        1-Navigate to the website
        driver.navigate().to("https://www.techtorialacademy.com/");
        //        2-Scroll All the way down to the "CopyRight 2023" and validate "Copyright © 2023
        Thread.sleep(1000);
        WebElement bottomText= driver.findElement(By.cssSelector("#el_1666192783854_462"));
        BrowserUtils.scrollIntoView(driver, bottomText);
        String expectedBottomText="Copyright © 2023";
        Assert.assertEquals(BrowserUtils.getText(bottomText).trim(), expectedBottomText);
//        3-Scroll All the way up to the "Launch a new tech Career".
        WebElement header= driver.findElement(By.xpath("//div[@id='el_1668758467708_538']//b"));
        Thread.sleep(1000);
        BrowserUtils.scrollIntoView(driver, header);
//        4-Click Apply Now button with JS.
        WebElement applyNowButton= driver.findElement(By.xpath("//span[contains(text(), 'Apply Now')]"));
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, applyNowButton);
//        5-Validate the title with JS "Apply Now"
        String expectedTitle="Apply Now";
        Assert.assertEquals(BrowserUtils.getTitleWithJS(driver), expectedTitle);
//        6-Validate the information at the middle which are "info@...etc","+ 1 (224) 570 91 91","Chicago & Houston"
        List<WebElement> middleInfo=driver.findElements(By.xpath("//h3[@class='lw-widget-in learnworlds-heading3 learnworlds-element learnworlds-heading3-small']"));
        List<String> expectedMiddleInfo= Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");
        for (int i=0; i<middleInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(middleInfo.get(i)).trim(), expectedMiddleInfo.get(i));
        }
//        7-close your all browsers(driver.quit)
        driver.quit();
    }
}
