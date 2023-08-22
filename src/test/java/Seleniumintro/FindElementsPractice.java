package Seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        //TASK
        //Please print out all the links with LOOPs
        //Count how many links you have
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> elements=driver.findElements(By.xpath("//li"));
        int count=0;
        Thread.sleep(2000);
        for (WebElement e:elements){

            System.out.println(e.getText());
            count++;

        }
        System.out.println(count);

        //Task 2:

        int counter1=0;
        for (WebElement link:elements){
            if (link.getText().trim().length()>=12){
                System.out.println(link.getText().trim());
                counter1++;
            }
        }
        System.out.println(counter1);

    }
}
