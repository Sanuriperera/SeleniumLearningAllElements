import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalendarExample {
    WebDriver driver;

    @BeforeMethod
    public void openCalendarTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);
    }

    @Test
    public void calendarTest(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //Method 1
//        //switch to the next frame
//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.sendKeys("12/25/2024");

        //Method 2
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        //Call for the select future date calendar method

//        selectFutureDate("2025","January","20");

        selectPastDate("2024","May","25");
    }
    public void selectFutureDate(String year,String month,String date){
        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        List<WebElement> allDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElement:allDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }

    public void selectPastDate(String year,String month,String date){
        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> allDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElement:allDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }

}
