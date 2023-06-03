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

        WebElement jsAlerts= driver.findElement(By.linkText("Javascript Alerts"));
        jsAlerts.click();



        WebElement js= driver.findElement(By.xpath("//p[contains(text(),'JS Alert')]//button"));
        js.click();

        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        String actualText= alert.getText().trim();
        String expectedText ="Alert box!";
        Assert.assertEquals(actualText,expectedText);

        alert.accept();

        WebElement confirm = driver.findElement(By.xpath("//p[contains(text(),'Confirm box:')]//button"));

        confirm.click();

        String actual2=alert.getText().trim();
        String expected2="Press a button!";
        Assert.assertEquals(actual2,expected2);

        alert.dismiss();

        WebElement cancelMsg= driver.findElement(By.cssSelector("#confirm-demo"));
        System.out.println(cancelMsg.getText().trim());

        WebElement prompt=driver.findElement(By.xpath("//p[contains(text(),'Prompt box:')]//button"));
        prompt.click();

        alert.sendKeys("Anna");
        alert.accept();

        WebElement demoMsg= driver.findElement(By.cssSelector("#prompt-demo"));

        String actualPrompt=demoMsg.getText().trim();
        String expectedPrompt="You have entered 'Anna' !";

        Assert.assertEquals(actualPrompt,expectedPrompt);





    }
}