import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ButtonExample {
WebDriver driver;
@BeforeMethod
public void openButtonTestPage(){
    driver = new ChromeDriver();
    // get required size of the browser
//    Dimension newSize =new Dimension(800,600);
//    driver.manage().window().setSize(newSize);
    driver.manage().window().maximize();
    driver.get("https://www.leafground.com/button.xhtml");
}
@Test
    public void buttonTest(){
//    01) Click and Confirm title
    WebElement confirmTitleBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
    confirmTitleBtn.click();

    String expectedTitle = "Dashboard";
    String actualTitle = driver.getTitle();

    if(expectedTitle.equals(actualTitle)){
        System.out.println("Actual title is same as expected title");
    }else{
        System.out.println("Actual title is not same as expected title");
    }
//    This is another method used in testNg for verify the title
//    Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");

//    02) Confirm if the button is disabled
    // navigate back to the button page from dashboard
    driver.navigate().back();
    boolean enable = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
    System.out.println("is this button is enable: "+enable);

//    03) Find the position of the Submit button
    WebElement getPosition =driver.findElement(By.id("j_idt88:j_idt94"));
    Point xyPoint = getPosition.getLocation();
    int x =xyPoint.getX();
    int y = xyPoint.getY();

    System.out.println("X position is : " + x);
    System.out.println("Y position is : "+ y);

//    04) Find the Save button color
    WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
    // expand background then use  background-color:
   String colour = buttonColour.getCssValue("background-color");
    System.out.println("The button colour is: " +colour);

//    05) Find the height and width of this button
 WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
    int height = size.getSize().getHeight();
    int width = size.getSize().getWidth();

    System.out.println("The Height : "+height + "The Width : "+width);


}

}
