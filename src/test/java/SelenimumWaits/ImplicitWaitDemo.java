package SelenimumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {
    WebDriver driver;

    @BeforeMethod
    public void  openTablePage(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void implicitWaitTest() throws InterruptedException {
        //Wait for Visibility (1 - 10 Sec)
        WebElement clickBtn1= driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']"));
        clickBtn1.click();

//        Thread.sleep(10000);
        String newBtnText= driver.findElement(By.xpath("//button[@id ='j_idt87:j_idt90']/span")).getText();
        System.out.println("New btn Text is : "+newBtnText);
    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }

}
