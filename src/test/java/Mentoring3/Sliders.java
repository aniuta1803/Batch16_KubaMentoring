package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Sliders {

@Test
    public void Test4(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote -allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.lambdatest.com/selenium-playground");

    WebElement Drag = driver.findElement(By.linkText("Drag & Drop Sliders"));
    Drag.click();

    List<WebElement> AllInputs= driver.findElements(By.xpath("//input[@type='range']"));
    List<WebElement> AllOutput = driver.findElements(By.cssSelector("output"));
    for(int i = 0; i<AllInputs.size(); i++){
        while(!AllOutput.get(i).getText().equals("50")){
            AllInputs.get(i).sendKeys(Keys.ARROW_RIGHT);

            if(AllOutput.get(i).getText().equals("50")){
                break;
            } else {
                AllInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
            }

        }    }


}
}
