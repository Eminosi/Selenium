package BaaberHomeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Task1 {
    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
//        Validate the title is equals to "Web Orders Login"
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(BrowserUtils.getTitleWithJS(driver), expectedTitle);
//        Input username "Tester"
        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
//        Input password "test"
        WebElement password= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
//        Click login button
        WebElement loginButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJS(driver, loginButton);
//        Validate the title is equals to "Web Orders"
        Thread.sleep(1000);
        String expectedTitleAfter="Web Orders";
        Assert.assertEquals(BrowserUtils.getTitleWithJS(driver), expectedTitleAfter);
//        Validate header is equals to "List of All Orders"
        WebElement header= driver.findElement(By.xpath("//h2"));
        String expectedHeader="List of All Orders";
        Assert.assertEquals(header.getText(), expectedHeader);
    }


    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
//        Input username "Tester"
        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
//        Input password "Test"
        WebElement password= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
//        Click login button
        WebElement loginButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJS(driver, loginButton);
//        Click "View all products" button
        Thread.sleep(1000);
        WebElement allProductsButton= driver.findElement(By.xpath("//a[@href='Products.aspx']"));
       BrowserUtils.clickWithJS(driver, allProductsButton);
//        Validate "View all products" is selected
        Thread.sleep(2000);
        Assert.assertTrue(allProductsButton.isSelected());
        Thread.sleep(1000);
//        Validate header is equals to "List of Products"
        WebElement header= driver.findElement(By.xpath("//h2"));
       String expectedHeader="List of Products";
        Assert.assertEquals(header.getText(), expectedHeader);
//        Validate the url has "Products" keyword
       Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
    }


    @Test
    public void testCase3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
//        Input username "Tester"
        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
//        Input password "Test"
        WebElement password= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
//        Click login button
        WebElement loginButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJS(driver, loginButton);
//        Find the links for
//        View all orders
        WebElement allOrder= driver.findElement(By.xpath("//a[@href='Default.aspx']"));
//        View all products
        WebElement allProducts=driver.findElement(By.xpath("//a[@href='Products.aspx']"));
//                Orders
        WebElement orders= driver.findElement(By.xpath("//a[@href='Process.aspx']"));
//        Validate their href values are equals to :
//        "Default.aspx"
        String expectedAllOrderHref="Default.aspx";
        String actualAllOrder=allOrder.getAttribute("href").trim();
        System.out.println(actualAllOrder);
        Assert.assertEquals(actualAllOrder, expectedAllOrderHref);
//        "Products.aspx"

//        "Process.aspx"
    }
}
