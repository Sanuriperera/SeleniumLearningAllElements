import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void openTextBoxTestPage(){
//        01) Type your name
//        Store the webElement toname variable
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        //Access the webElement called name
        name.sendKeys("Sanuri Perera");

//        02) Append Country to this City.
        WebElement city = driver.findElement(By.id("j_idt88:j_idt91"));
        city.sendKeys("India");

//        03) Verify if text box is disabled
        boolean enable = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("is this textbox is enable: "+enable);

//        04) Clear the typed text.
//        //*[@id="j_idt88:j_idt95"] => this is copied xpath
        WebElement cleartext = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        cleartext.clear();

//        05) Retrieve the typed text.get the attribute value = My learning is superb so far.
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println("Retrieve the value in value attribute: "+value);

//        06) Type email and Tab. Confirm control moved to next element.
        WebElement email= driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("sanuriperera98@gmail.com" + Keys.TAB + "Confirm control moved to next element");

//        07) Type about yourself
//        08) Text Editor

    }

}
