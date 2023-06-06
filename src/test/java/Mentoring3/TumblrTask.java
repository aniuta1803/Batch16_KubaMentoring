package Mentoring3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.concurrent.Callable;

public class TumblrTask {
    @Test
    public void FacebookTask() throws InterruptedException {
        /*
 Navigate to webapp
click login button
click continue with email button
provide email, and password (wrong credentials)
and validate the error message
driver quit
!!! probably need to delete cookies !!!
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        WebElement LoginButton = driver.findElement(By.linkText("Log in"));
        LoginButton.click();
        Thread.sleep(3000);
       WebElement ContinueWithEmail = driver.findElement(By.xpath("//button[@aria-label='Continue with email']"));
       ContinueWithEmail.click();
       Thread.sleep(3000);
       WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
       Email.sendKeys("aaa1@gmail.com");
       WebElement NextButton = driver.findElement(By.xpath("//button[@aria-label='Next']"));
       NextButton.click();
       WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
       Password.sendKeys("111112");

       WebElement LoginButton2 = driver.findElement(By.xpath("//button[@aria-label='Log in']"));
       LoginButton2.click();
       Thread.sleep(3000);

       WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
       String ActualMessage = BrowserUtils.getText(ErrorMessage);
       String ExpectedMessage = "Your email or password were incorrect.";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
       driver.quit();
    }


    }

