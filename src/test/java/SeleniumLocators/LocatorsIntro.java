package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    //LOCATORS: Is a way to locate (find) the element and manipulate it
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/almat/Downloads/Techtorialhtml.html");
        WebElement header= driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());//Techtorial Academy
        String actualHeader=header.getText();
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Molly");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Assy");
        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("9299999999");
        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("mo@mail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("1000 Polly dr");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("Illinois");
        WebElement zipCode=driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("50009");

        //ClASSNAME LOCATOR:
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox= driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
        }
        WebElement testNGBox=driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed()&& !testNGBox.isSelected()){
              testNGBox.click();
        }
        WebElement cucumber=driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed()&& !cucumber.isSelected()){
            cucumber.click();
        }

    }
}
