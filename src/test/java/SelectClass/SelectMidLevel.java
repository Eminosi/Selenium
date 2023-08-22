package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevel {
     /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available"


 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */

@Test
    public void validateOrderFunctionality() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
    //Select one way trip button
    WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
    oneWay.click();
    //Choose 4 passangers
    WebElement passCount= driver.findElement(By.xpath("//select[@name='passCount']"));
    Select passengerCount=new Select(passCount);
    passengerCount.selectByValue("4");
    //    Validate the depart from is default "Acapulco"
    WebElement depart= driver.findElement(By.xpath("//select[@name='toPort']"));
    Select departCity=new Select(depart);
    String actualDepart=departCity.getFirstSelectedOption().getText().trim();
    String expectedDepart="Acapulco";
    Assert.assertEquals(actualDepart,expectedDepart);
//    5-Choose the depart from is Paris
    Thread.sleep(1000);
    departCity.selectByVisibleText("Paris");
//    6-Choose the date August 15th
    WebElement dateMonth= driver.findElement(By.xpath("//select[@name='fromMonth']"));
    Select dateMonth1=new Select(dateMonth);
    dateMonth1.selectByVisibleText("August");
    WebElement dateDay= driver.findElement(By.xpath("//select[@name='fromDay']"));
    Select dateDay1=new Select(dateDay);
    dateDay1.selectByValue("15");
//    7-Choose the arrive in is San Francisco
    WebElement arriveCity= driver.findElement(By.xpath("//select[@name='toPort']"));
    Select arrCity=new Select(arriveCity);
    arrCity.selectByVisibleText("San Francisco");
//    8-Choose the date December 15th
    WebElement toDateMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
    Select toDateMonth1=new Select(toDateMonth);
    toDateMonth1.selectByValue("12");
    WebElement toDateDay= driver.findElement(By.xpath("//select[@name='toDay']"));
    Select toDateDay1=new Select(toDateDay);
    toDateDay1.selectByValue("15");
//    10-Click first class option.
    WebElement firstClass= driver.findElement(By.xpath("//input[@value='First']"));
    firstClass.click();

//    11-Validate All the options from Airline
    Thread.sleep(1000);
    WebElement airlinesBox= driver.findElement(By.xpath("//select[@name='airline']"));
    Select airline=new Select(airlinesBox);
    List<WebElement> actualAirlines=airline.getOptions();
    List <String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines", "Pangea Airlines");
    for (int i=0; i<actualAirlines.size();i++){
        Assert.assertEquals(actualAirlines.get(i).getText().trim(), expectedAirlines.get(i));
    }
//    12-Choose the Unified option from airline list
    airline.selectByVisibleText("Unified Airlines");

//    13-Click Continue
    WebElement continueButton= driver.findElement(By.xpath("//input[@name='findFlights']"));
    continueButton.click();

//    14-Validate the message from header which should be "After flight finder - No Seats Available"
    WebElement header= driver.findElement(By.xpath("//font[@size='4']"));
    String actualHeader= header.getText().trim();
    String expectedHeader="After flight finder - No Seats Available";
    Assert.assertEquals(actualHeader,expectedHeader);



}

@Test
    public void shortCutAutomation() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
    //Select one way trip button
    WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
    oneWay.click();
    //Choose 4 passangers
    WebElement passCount= driver.findElement(By.xpath("//select[@name='passCount']"));
    BrowserUtils.selectBy(passCount, "4", "value");
    //    Validate the depart from is default "Acapulco"
    WebElement depart= driver.findElement(By.xpath("//select[@name='toPort']"));
    Select departCity=new Select(depart);
    String actualDepart=departCity.getFirstSelectedOption().getText().trim();
    String expectedDepart="Acapulco";
    Assert.assertEquals(actualDepart,expectedDepart);
//    5-Choose the depart from is Paris
    BrowserUtils.selectBy(depart, "Paris", "value");
   // departCity.selectByVisibleText("Paris");
//    6-Choose the date August 15th
    WebElement dateMonth= driver.findElement(By.xpath("//select[@name='fromMonth']"));
    Select dateMonth1=new Select(dateMonth);
    dateMonth1.selectByVisibleText("August");
    WebElement dateDay= driver.findElement(By.xpath("//select[@name='fromDay']"));
    Select dateDay1=new Select(dateDay);
    dateDay1.selectByValue("15");
//    7-Choose the arrive in is San Francisco
    WebElement arriveCity= driver.findElement(By.xpath("//select[@name='toPort']"));
    Select arrCity=new Select(arriveCity);
    arrCity.selectByVisibleText("San Francisco");
//    8-Choose the date December 15th
    WebElement toDateMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
    Select toDateMonth1=new Select(toDateMonth);
    toDateMonth1.selectByValue("12");
    WebElement toDateDay= driver.findElement(By.xpath("//select[@name='toDay']"));
    Select toDateDay1=new Select(toDateDay);
    toDateDay1.selectByValue("15");
//    10-Click first class option.
    WebElement firstClass= driver.findElement(By.xpath("//input[@value='First']"));
    firstClass.click();

//    11-Validate All the options from Airline
    Thread.sleep(1000);
    WebElement airlinesBox= driver.findElement(By.xpath("//select[@name='airline']"));
    Select airline=new Select(airlinesBox);
    List<WebElement> actualAirlines=airline.getOptions();
    List <String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines", "Pangea Airlines");
    for (int i=0; i<actualAirlines.size();i++){
        Assert.assertEquals(actualAirlines.get(i).getText().trim(), expectedAirlines.get(i));
    }
//    12-Choose the Unified option from airline list
    airline.selectByVisibleText("Unified Airlines");

//    13-Click Continue
    WebElement continueButton= driver.findElement(By.xpath("//input[@name='findFlights']"));
    continueButton.click();

//    14-Validate the message from header which should be "After flight finder - No Seats Available"
    WebElement header= driver.findElement(By.xpath("//font[@size='4']"));
    String actualHeader= BrowserUtils.getText(header);
    String expectedHeader="After flight finder - No Seats Available";
    Assert.assertEquals(actualHeader,expectedHeader);

}






}
