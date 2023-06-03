package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Callable;

public class AlertsPractice {
    @Test
    public void Test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement JSAlert = driver.findElement(By.linkText("Javascript Alerts"));
        JSAlert.click();
        Thread.sleep(2000);
        Alert alert =driver.switchTo().alert();
        alert.accept();

        WebElement ConfirmBox = driver.findElement(By.linkText("Confirm box:"));
        ConfirmBox.click();
        String actualText = alert.getText().trim();
        String expecytedText="Press a button!";
        Assert.assertEquals(actualText,expecytedText);
        alert.dismiss();

      WebElement  Message = driver.findElement(By.cssSelector("#confirm-demo"));
        System.out.println(Message.getText());

        WebElement PromptButton = driver.findElement(By.linkText("Prompt box:"));
        PromptButton.click();

        alert.sendKeys("Anna");
        alert.accept();

        WebElement Text1= driver.findElement(By.cssSelector("#prompt-demo"));
       String ActualT1 = Text1.getText();
        String expectedText1="You have entered 'Anna' !";
        Assert.assertEquals(ActualT1,expectedText1);



    }
}