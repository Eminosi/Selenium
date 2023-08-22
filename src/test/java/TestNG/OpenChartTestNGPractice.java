package TestNG;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {
    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton= driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(5000);
        String actualTitle= driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void alert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demos");
        WebElement password= driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton= driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertWindow= driver.findElement(By.cssSelector("#alert"));
        Thread.sleep(1000);
        String actualText= alertWindow.getText();
        String expectedText="No match for Username and/or Password.";
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton= driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement closeButton= driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog= driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        WebElement product= driver.findElement(By.linkText("Products"));
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());
        driver.quit();
    }
    //TIPS:
//1-Find the all boxes location for the first page
//2-Use regular loop and start from i=1 because i=0 is choosing all boxes right away
//3-This box is displayed
//4-The box is enabled
//5-The box is not selected(Assert.assertFalse)
//6-Click
//7-The box is selected(Assert.AssertTrue)
//Thread.sleep(1000)
//sendKeys(Keys.Arrow) -->We did in youtube remember
    @Test
    public void validateBoxesFunctionalityProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton= driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement closeButton= driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog= driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        WebElement product= driver.findElement(By.linkText("Products"));
        product.click();
        List <WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i=1; i< boxes.size();i++){
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            Assert.assertTrue(boxes.get(i).isEnabled() &&boxes.get(i).isDisplayed());
            Assert.assertFalse(boxes.get(i).isSelected());
            Thread.sleep(500);
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
    }
   // TASK 2:
//1-you click Products button
//2-You click ProductName Button
//3-You validate that the All product Name are listed as DESCENDING ORDER
//TIPS:Collections.sort and Collections.reverse() method will help
//TIPS:One loop will be enough to complete this task.
    // NOTE:We will do task 1 and task2 in class together on TUESDAY.
    @Test
    public void validateOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username= driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password= driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton= driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement closeButton= driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog= driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        WebElement product= driver.findElement(By.linkText("Products"));
        product.click();
        Thread.sleep(2000);
        List <WebElement> products=driver.findElements(By.xpath("//td[@class='text-start']"));

       List <String> expectedProduct=new ArrayList<>();
        List <String> actualProduct=new ArrayList<>();
        for (int i=1; i<products.size(); i++){

            actualProduct.add(products.get(i).getText().toLowerCase().trim());
            expectedProduct.add(products.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProduct);
        System.out.println(expectedProduct);
        System.out.println(actualProduct);
        Assert.assertEquals(actualProduct,expectedProduct);

        }
@Test
        public void ValidateDescendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username= driver.findElement(By.cssSelector("#input-username"));
            username.sendKeys("demo");
            WebElement password= driver.findElement(By.cssSelector("#input-password"));
            password.sendKeys("demo");
            WebElement loginButton= driver.findElement(By.xpath("//button"));
            loginButton.click();
            Thread.sleep(1000);
            WebElement closeButton= driver.findElement(By.cssSelector(".btn-close"));
            closeButton.click();
            WebElement catalog= driver.findElement(By.xpath("//a[@href='#collapse-1']"));
            catalog.click();
            WebElement product= driver.findElement(By.linkText("Products"));
            product.click();
            WebElement productNameButton= driver.findElement(By.cssSelector(".asc"));
            productNameButton.click();
            Thread.sleep(2000);
            List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualProducts=new ArrayList<>();
            List<String> expectedProducts=new ArrayList<>();
            for (int i=1; i<allProducts.size(); i++){
                actualProducts.add(allProducts.get(i).getText().toLowerCase().trim());
                expectedProducts.add(allProducts.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expectedProducts);//ascending order
            Collections.reverse(expectedProducts);//descending order
    System.out.println(actualProducts);
    System.out.println("=========");
    System.out.println(expectedProducts);
    Assert.assertEquals(actualProducts, expectedProducts);

        }
    }

