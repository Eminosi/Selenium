package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
           */

public class XpathRealHealthProject {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement appoitment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appoitment.click();

        WebElement username= driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");

        WebElement password= driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton= driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility= driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Seoul CURA Healthcare Center");

        WebElement readmissionButton= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (readmissionButton.isDisplayed()&& !readmissionButton.isSelected()){
         readmissionButton.click();
        }
        System.out.println(readmissionButton.isSelected()?"Selected": "Not Selected");

        WebElement medicaid= driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement visitDate= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("08/08/2024");

        WebElement comment= driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Can come later for 10 minutes");

        WebElement bookAppoitment= driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppoitment.click();

        WebElement confirmationHeader= driver.findElement(By.xpath("//h2[contains(text(), 'Appointment Confirmation')]"));
        String actualHeader=confirmationHeader.getText();
        String expectedHeader="Appointment confirmation";
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header Confirmed");
        }else {
            System.out.println("Header not confirmed");
        }

        WebElement facilityResult= driver.findElement(By.xpath("//p[contains(text(), 'Seoul CURA')]"));
        System.out.println(facilityResult.getText());

        WebElement applyFor= driver.findElement(By.xpath("//p[contains(text(), 'Yes')]"));
        System.out.println(applyFor.getText());

        WebElement HealthProgram=driver.findElement(By.xpath("//p[contains(text(), 'Medicaid')]"));
        System.out.println(HealthProgram.getText());

        WebElement visitDate1= driver.findElement(By.xpath("//p[contains(text(), '08/08/2024')]"));
        System.out.println(visitDate1.getText());

        WebElement commentPrint= driver.findElement(By.xpath("//p[contains(text(), 'Can come later')]"));
        System.out.println(commentPrint.getText());

        WebElement homePage=driver.findElement(By.xpath("//a[contains(text(), 'Go to Homepage')]"));
        homePage.click();

        System.out.println(driver.getCurrentUrl());
        driver.close();



    }
}
