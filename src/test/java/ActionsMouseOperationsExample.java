import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsMouseOperationsExample {
    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestsBrowserOpen(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouseOperationsTest() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("1) <<<<<<<<<<<<<<<Move to an element operation>>>>>>>>>>>>>>>");
        //for mouse hover effect
        Actions actions=new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
//        Thread.sleep(3000);

        // Another Method
        //Ued . chain method
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        System.out.println("2) <<<<<<<<<<<<<<<Drag and Drop operation>>>>>>>>>>>>>>>");

        WebElement from = driver.findElement(By.id("form:drag_content"));
        WebElement to  = driver.findElement(By.id("form:drop_content"));

        // 1 way
//        actions.clickAndHold(from).moveToElement(to).release(to).perform();

        //2 way
        actions.dragAndDrop(from,to).perform();

        System.out.println("3) <<<<<<<<<<<<<<<Slider Operation>>>>>>>>>>>>>>>");

        WebElement sliderPoint1= driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        //To get sliderpoint1 location
        System.out.println("Location od sliderpoint 1 before moving :"+sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1,50,0).perform();
        System.out.println("Location od sliderpoint 1 after moving :" + sliderPoint1.getLocation());

    }

    @Test
    public void mouseOperationsTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("4) <<<<<<<<<<<<<<<Right click>>>>>>>>>>>>>>>");
        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1=new Actions(driver);
        actions1.contextClick(rightClickButtonElement).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertPop =driver.switchTo().alert();
        System.out.println("Alert shows the text as : "+ alertPop.getText());
        alertPop.accept();
    }
}
