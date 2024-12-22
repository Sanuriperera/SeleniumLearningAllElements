import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class frameExample {
// 1 example Click Me (Inside frame)
    //       **** frames = html page, inside main html page (need to swith one time)
    //                html
    //                    html

//2 Example
    //       ****  nested frames =   need to switch two times
    //                html
    //                    html
    //                        html
    WebDriver driver;

    @BeforeMethod
    public void frameTestPage(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void  frameTests(){
        //1) Click Me (Inside frame)
        driver.switchTo().frame(0);
       WebElement button1= driver.findElement(By.xpath("//button[@id='Click']"));
       button1.click();

       String afterClickButtonText= button1.getText();
        System.out.println("After click inside frame button text "+afterClickButtonText);

        //  2) Click Me (Inside Nested frame)
        driver.switchTo().defaultContent();

        //inside into 3 frame
        driver.switchTo().frame(2);
        //switch to inside frame to click the button (inside into 3rd frame > child frame)
        driver.switchTo().frame("frame2");

       WebElement button3= driver.findElement(By.xpath("//button[@id='Click']"));
       button3.click();

        String afterClickButtonText3= button3.getText();
        System.out.println("After click inside nested frame button text "+afterClickButtonText3);

        // 3) How many frames in this page?
        driver.switchTo().defaultContent();
        List<WebElement> getIframeTagCount= driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        //this give iframe used in main iframe
        System.out.println("Iframe tag count: "+size);

        for(WebElement iframeElement:getIframeTagCount){
            String frameSrcAttributeValue = iframeElement.getAttribute("src");
            System.out.println("frame src attribute vale : "+frameSrcAttributeValue
            );
        }
    }
}
