import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;

    @BeforeMethod
    public void alertTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest(){
        //1) Alert (Simple Dialog)

        WebElement simpleAlertBtn=driver.findElement(By.id("j_idt88:j_idt91"));
        simpleAlertBtn.click();
        // switch to alert and save in a  variable
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        //2) Alert (Confirm Dialog)
        WebElement confirmBoxbtn = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBoxbtn.click();
        Alert alert1=driver.switchTo().alert();
        //dismiss the alert
        alert1.dismiss();

//        3) Alert (Prompt Dialog)
        WebElement promtBoxBtn= driver.findElement(By.id("j_idt88:j_idt104"));
        promtBoxBtn.click();
        Alert promtAlert=driver.switchTo().alert();
        String alertboxText=promtAlert.getText();
        System.out.println("The text in the alertbox is : "+alertboxText);
        promtAlert.sendKeys("Sanuri Perera");
        promtAlert.accept();

    }

}
