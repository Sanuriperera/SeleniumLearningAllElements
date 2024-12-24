import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyBoardExample {
    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationstestsBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keyboardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        //this is using webelement sendkeys
//        googleSearchTextBox.sendKeys("welcome");
//
//        Actions actions = new Actions(driver);
//        //select the text (Ctrl+a)
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(5000);
//
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentence").perform();
//        Thread.sleep(5000);
//        actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .perform();


        //To write in capital in a textbox
        Actions actions = new Actions(driver);
        actions.keyDown(googleSearchTextBox,Keys.SHIFT)
                .sendKeys("Learn")
                .perform();

    }

    @Test
    public void keyboardActionsTest2(){
        driver.get("https://www.leafground.com/list.xhtml");
        List<WebElement>  selectable= driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("list of count is : "+size);

        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
}
