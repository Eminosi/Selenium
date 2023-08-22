package Seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
//TASK:
//1-Navigate to the youtube
//2-Search for Justin Bieber
//3-Find the location of all links
//4-Once this link equals to "Justin Bieber - Baby ft. Ludacris"
//think about getAttribute method
//5-Click the link and make sure the video is playing
//NOTE:Inside of the loop you can use this method(inside of if)
//Thread.sleep(1000)
//song.sendKeys(Keys.ARROW_DOWN)

public class YouTubeRealInterview {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        Thread.sleep(5000);
        WebElement searchButton= driver.findElement(By.xpath("//input[@id='search']"));

        searchButton.sendKeys("Justin Bieber");
        searchButton.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        List<WebElement> songs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song:songs){
            if (song.getAttribute("title").equalsIgnoreCase("Justin Bieber - Baby ft. Ludacris")){
                Thread.sleep(1000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();

            }
        }


    }
}
