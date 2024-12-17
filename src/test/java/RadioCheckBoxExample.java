import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void radioCheckboxBeforeTests(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest(){
        //        <<<<<<<<<<<<<<Radio >>>>>>>>>>>>>>>>>>>>>
        //  1) Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeRadioOption=driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption=driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption=driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption=driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeRadioOption){
          String chromeText = driver.findElement(By.xpath("//label[@ for='j_idt87:console2:0']")).getText();
            System.out.println("Default selected radio button is: " + chromeText);
        } else if (firefoxRadioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@ for='j_idt87:console2:1']")).getText();
            System.out.println("Default selected radio button is: " + firefoxText);
        } else if (safariRadioOption) {
            String safariText = driver.findElement(By.xpath("//label[@ for='j_idt87:console2:2']")).getText();
            System.out.println("Default selected radio button is: " + safariText);
        } else if (edgeRadioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@ for='j_idt87:console2:3']")).getText();
            System.out.println("Default selected radio button is: " + edgeText);
        }
        else {
            System.out.println("Default radio button is not selected");
        }

        //second advance method
     /**   List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int radioCount=radioElements.size();
        System.out.println("Radio size: "+radioCount);


        for (WebElement radioElement:radioElements){
            int index=-1;
            if(radioElement.isSelected()) {
                WebElement defeaultSelectedRadioButton = driver.findElement(By.xpath("//label[@ for='j_idt87:console2:" + index + "']"));
                String defaultSelectedRadioButtonText = defeaultSelectedRadioButton.getText();
                System.out.println("Default selected radio button is: " + defaultSelectedRadioButtonText);
                break;
            }
        }*/

        //  2) Select the age group (only if not selected)

        WebElement myAgeGroup=driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if(!isChecked){
//            myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for= 'j_idt87:age:0']")).click();
        }
    }

    //Advance method
//    String myAge="1-20";
//    List<WebElement> ageGroup2 = driver.findElements(By.xpath("//div[@id='j_idt87:age']//label"));
//

    @Test
    public void checkBoxTest(){
//        <<<<<<<<<<<Checkbox>>>>>>>>>>>>>
//        1) Select wanted checkboxes and verifying those checkboxes selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");

//        Choose your favorite language(s)
        List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement check:checkboxList){
            if(!(check.getText().equals("Others"))){
                check.click();
            }
        }

        for (int i=1;i<=checkboxList.size();i++){
            boolean checkboxStatus=driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("Checkbox "+i+"selected status is : " + checkboxStatus);
        }
    }
}
