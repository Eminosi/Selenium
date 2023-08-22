package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTim {
    public static void main(String[] args) {
        /*
        Navigate to website 'google'

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        WebElement searchButton= driver.findElement(By.id("APjFqb"));
        searchButton.sendKeys("indian food", Keys.ENTER);
        WebElement firstOption= driver.findElement(By.xpath("//h3[.='15 Best Indian Delivery Restaurants in Des Plaines']"));
        firstOption.click();

    }
}
