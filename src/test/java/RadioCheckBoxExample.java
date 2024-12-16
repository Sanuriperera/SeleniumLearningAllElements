import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class RadioCheckBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void radioCheckboxBeforeTests(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void radioTest(){
//        <<<<<<<<<<<<<<Radio >>>>>>>>>>>>>>>>>>>>>

    }
}
