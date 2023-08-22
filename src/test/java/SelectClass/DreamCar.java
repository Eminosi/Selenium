package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void SearchFunctionality(){

//NOTE: Please use browser utils for the select classes if it is needed or getText.
//1-Navigate to the website
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
//2-Choose the "New" from the New/used option
        WebElement newOption= driver.findElement(By.xpath("//select[@data-activitykey='hp-stock-type-change']"));
        BrowserUtils.selectBy(newOption,"new","value" );
//3-Choose "Lexus" for Make part
        WebElement make= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");
//4-Choose "RX-350"
        WebElement rx350= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(rx350,"lexus-rx_350", "value");
//5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceBox=new Select(price);
        String actualPrice=priceBox.getFirstSelectedOption().getText().trim();
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
//6-Choose the distance 40 mil
        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40", "value");
//7-Put your Zip code-->Before that Clear it.60056 element.clear()
        WebElement zipCode= driver.findElement(By.xpath("//input[@data-activitykey='hp-zip-change']"));
        zipCode.clear();
        zipCode.sendKeys("60056");
//8-Click Search Button
        WebElement searchButton= driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
//9-Validate the header "New Lexus RX 350 for sale"
        WebElement header= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader=header.getText();
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
//10-Click Sort by and choose the Lowest Price
        WebElement sortButton=driver.findElement(By.xpath("//select[@data-activitykey='sort-dropdown']"));
        BrowserUtils.selectBy(sortButton, "Lowest price", "text");
//11-Validate the all titles has Lexus RX 350
        List <WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title:allTitles){
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
        }
    }
    @Test
    public void dreamCar() throws InterruptedException {
        //1-Navigate to the website
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
//2-Choose the "New" from the New/used option
        WebElement newOption= driver.findElement(By.xpath("//select[@data-activitykey='hp-stock-type-change']"));
        BrowserUtils.selectBy(newOption,"new","value" );
//3-Choose "Mercedes-Benz" for Make part
        WebElement make= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Mercedes-Benz", "text");

        //4-Choose "mercedes_benz-maybach_s_680"
        WebElement maybach= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(maybach,"mercedes_benz-maybach_s_680", "value");
//5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceBox=new Select(price);
        String actualPrice=priceBox.getFirstSelectedOption().getText().trim();
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
//6-Choose the distance 40 mil
        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40", "value");
//7-Put your Zip code-->Before that Clear it.60056 element.clear()
        WebElement zipCode= driver.findElement(By.xpath("//input[@data-activitykey='hp-zip-change']"));
        zipCode.clear();
        zipCode.sendKeys("60056");
//8-Click Search Button
        WebElement searchButton= driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
//9-Validate the header "New Mercedes-Benz Maybach S 680 for sale"
        WebElement header= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader=header.getText();
        String expectedHeader="New Mercedes-Benz Maybach S 680 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
//10-Click Sort by and choose the Lowest Price
        Thread.sleep(1000);
        WebElement sortButton=driver.findElement(By.xpath("//select[@data-activitykey='sort-dropdown']"));
        BrowserUtils.selectBy(sortButton, "Lowest price", "text");
        Thread.sleep(1000);
//11-Ascending order
        List <WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));
        List <Double> actualPrices=new ArrayList<>();
        List <Double> expectedPrices=new ArrayList<>();
        for (int i=0; i<allPrices.size(); i++){
            if (allPrices.get(i).getText().equalsIgnoreCase("Not Priced")){

            }else {
                actualPrices.add(Double.parseDouble(allPrices.get(i).getText().replace("$", "")
                        .replace(",", "").trim()));//$54.33->5433
                expectedPrices.add(Double.parseDouble(allPrices.get(i).getText().replace("$", "")
                        .replace(",", "").trim()));
            }
        }
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);

    }
}
