package demo.wrappers;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    By name= By.xpath("");




    public void sendKeys(WebElement element,String message)  {
        element.sendKeys(message);
    }
    public void elementClick(WebElement element)  {
        element.click();
    }

    public void selectSkill(WebDriver driver,String skill)  {
        List<WebElement> choices=driver.findElements(By.xpath("//div[@jscontroller='sW52Ae']//div[@role='listitem']//div[@role='checkbox']"));

        for(WebElement e:choices)  {
            String choice =e.getAttribute("aria-label");
            if(choice.equals(skill))  {
                e.click();
            }
        }
    }

    public void selectAddressedBy(WebDriver driver,String title)  {
        List<WebElement> choices=driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']//div[@jsname='wQNmvb']"));

        for(WebElement e:choices)  {
            String choice =e.getAttribute("data-value");
            if(choice.equals(title))  {
                e.click();
            }
        }
    }

    public String date7DaysAgo()  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-7);
        String dayBefore=sdf.format(cal.getTime());

        return dayBefore;
    }
    public List<String> setTime()  {
        List<String >time=new ArrayList<>();
//        System.out.println("List is "+time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Calendar cal = Calendar.getInstance();
        String systemTime=sdf.format(cal.getTime());

        String arr[]=systemTime.split(":");
        time.add(arr[0]);
        time.add(arr[1]);
//        System.out.println(time);
        return time;
    }
}
