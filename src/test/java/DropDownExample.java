import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;
    @BeforeMethod
    public void openDropDownTestPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void leafgroundPageDropDownTest() throws InterruptedException {

        // openLeafgroungPage
        driver.get("https://www.leafground.com/select.xhtml");

        //    1.1) Ways of select values in Basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

//    1.2) Get the number of dropdown options
        // generics
        List<WebElement> listOptions= select.getOptions();
        int size = listOptions.size();
        System.out.println("Number of elements in dropdown : "+ size);

//        Print list of options in dropdown
        for (WebElement element:listOptions){
            System.out.println(element.getText());
        }

//    1.3) Using sendkeys select dropdown value
        dropdown.sendKeys("Puppeteer");

//    1.4) Selecting value in a Bootstrap dropdown
       WebElement dropdown2 =  driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
       dropdown2.click();
        List<WebElement> listofDropdown2Values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element:listofDropdown2Values){
           String dropDownValue = element.getText();
           if(dropDownValue.equals("USA")){
               element.click();
               break;
           }
        }
    }

    //    2) Google Search - pick a value suggestion
    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        //Locate the searchbar
        WebElement search = driver.findElement(By.name("q"));
//        write a text
        search.sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println("Google search list size : "+ googleSearchList.size());

        for (WebElement element:googleSearchList){
            String googledropdownvalue2 = element.getText();
            if(googledropdownvalue2.equals("Palitha Thewarapperuma")){
                element.click();
                break;
            }
        }

    }

//    3) Handle Hidden Auto Suggestions DropDown And search using DOM Debugger Trick
    
}
