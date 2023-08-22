package ActionsPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveToElementPractice {
    @Test
    public void MoveToElementPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //        1-Navigate to the website
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(2000);
        //        2-If you have cookies pop-up then click
        WebElement cookieAccept=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieAccept.click();
        //        3-Hover over each pictures and get the names and store it in List<String> allNames

        List<WebElement> allPictures=driver.findElements(By.xpath("//div[@role='listitem']"));
        List <WebElement> allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String, String> ProductInfo=new HashMap<>();
        Actions actions=new Actions(driver);
        for (int i=0; i<allPictures.size(); i++){
            actions.moveToElement(allPictures.get(i)).perform();
            ProductInfo.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(ProductInfo);

//        4-Hover over each pictures and get the prices and store it in List<String> all prices
//        5-Put them all of the names as key of map, and all of the prices as value of map
//        6-Print out map
//
//        CLUES:You can use 1 regular(indexing) loop for adding the name and prices into the lists
//        CLUES:You can use same loop for putting into the map
//        CLUES:TO ab ele to get names and prices you need to hover over first
//        CLUES:DO not forget perform

    }

}
