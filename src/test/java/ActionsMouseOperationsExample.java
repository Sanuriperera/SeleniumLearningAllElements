import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

public class ActionsMouseOperationsExample {
    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestsBrowserOpen(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void mouseOperationsTest(){
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("1) <<<<<<<<<<<<<<<Move to an element operation>>>>>>>>>>>>>>>");
        //for mouse hover effect
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();

        System.out.println("2) <<<<<<<<<<<<<<<Drag and Drop operation>>>>>>>>>>>>>>>");
        System.out.println("3) <<<<<<<<<<<<<<<Slider Operation>>>>>>>>>>>>>>>");
    }
}
