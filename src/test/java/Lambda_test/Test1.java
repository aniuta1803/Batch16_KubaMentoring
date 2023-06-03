package Lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test()
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement InputSubmit = driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]"));
        InputSubmit.click();
        Thread.sleep(2000);
        WebElement Name = driver.findElement(By.cssSelector("#name"));
        Name.sendKeys("Ana");
        WebElement Email = driver.findElement(By.cssSelector("#inputEmail4"));
        Email.sendKeys("aniuta111@gmail.com");
        WebElement Password = driver.findElement(By.cssSelector("#inputPassword4"));
        Password.sendKeys("113456a");
        WebElement Company = driver.findElement(By.cssSelector("#company"));
        Company.sendKeys( "Codefish");

        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("www.hfdchfc.com");

        WebElement Country = driver.findElement(By.linkText("Country*"));
        Country.sendKeys("Algeria");

        WebElement City = driver.findElement(By.cssSelector("#inputCity"));
        City.sendKeys("Chicago");

        WebElement Address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        Address1.sendKeys("111 des plaines");

        WebElement Address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        Address1.sendKeys("222 des plaines");

        WebElement State = driver.findElement(By.cssSelector("#inputState"));
        State.sendKeys("IL");

        WebElement ZipCode = driver.findElement(By.cssSelector("#inputZip"));
        ZipCode.sendKeys("60621");

        WebElement Button = driver.findElement(By.cssSelector(".selenium_btn"));
        Button.click();

        WebElement Message = driver.findElement(By.cssSelector(".success-msg"));
        String ActualMessage = Message.getText();
        String ExpectedMessage = "Thanks for contacting us, we will get back to you shortly.";

        Assert.assertEquals(ActualMessage,ExpectedMessage);





    }


    }


