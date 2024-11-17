package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers wrappers=new Wrappers();

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

    }
    @Test
    public void testCase01() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//     finding out web element for name
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        WebElement name = driver.findElement(By.xpath("//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']//input"));
        wrappers.sendKeys(name,"Crio Learner");
//    finding out web element for "Why are you practicing Automation?

        WebElement practicing_Automation = driver.findElement(By.tagName("textarea"));
        long epoch = System.currentTimeMillis();
        wrappers.sendKeys(practicing_Automation,"I want to be the best QA Engineer! "+epoch);
        WebElement exprience = driver.findElement(By.xpath("//div[@data-value='3 - 5']/div/div"));
        wrappers.elementClick(exprience);
// Selecting a skill set using selectskill method. it's user defined
        wrappers.selectSkill(driver,"Java");
        wrappers.selectSkill(driver,"Selenium");
        wrappers.selectSkill(driver,"TestNG");
//Selecting addressed learner
        WebElement learnerAddressed=driver.findElement(By.xpath("//span[text()='Choose']//parent::div"));
        wrappers.elementClick(learnerAddressed);
        wrappers.selectAddressedBy(driver,"Ms");
        Thread.sleep(2000);
// Putting a date before 7 days ago.
        WebElement dateSelected=driver.findElement(By.xpath("//input[@type='date']"));
       wrappers.sendKeys(dateSelected,wrappers.date7DaysAgo());
// Using list of string store the HH and mm and putting into respective field
       List<String> time=wrappers.setTime();
       WebElement hour=driver.findElement(By.xpath("//input[@aria-label='Hour']"));
       wrappers.sendKeys(hour,time.get(0));
        WebElement minute=driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        wrappers.sendKeys(minute,time.get(1));
// Finding out submit button and clicking on that button
        WebElement submitButton=driver.findElement(By.xpath("//div[@aria-label='Submit']"));
        submitButton.click();
// Printing the success message
        Thread.sleep(3000);
        WebElement successMessage1=driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        WebElement successMessage2=driver.findElement(By.xpath("//a[text()='Submit another response']"));

        System.out.println("First success message is "+successMessage1.getText());
        System.out.println("Second success message is "+successMessage2.getText());



    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}