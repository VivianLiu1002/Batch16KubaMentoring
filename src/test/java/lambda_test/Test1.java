package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
    @Test
    public void validateForm() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement submitForm= driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        submitForm.click();
        Thread.sleep(2000);
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Vivian");
        WebElement email= driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("yabingliu530@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("123456");
        WebElement company= driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("CodeFish");
        WebElement website= driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("codefish.io");
        WebElement countryButton=driver.findElement(By.xpath("//select[@name='country']"));
        BrowserUtils.selectBy(countryButton,"US","value");
        WebElement city= driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Chicago");
        WebElement address1= driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("123 Main St.");
        WebElement address2=driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("...");
        WebElement state=driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");
        WebElement zipcode=driver.findElement(By.cssSelector("#inputZip"));
        zipcode.sendKeys("60616");
        Thread.sleep(2000);
        WebElement submitButton=driver.findElement(By.xpath("//button[.='Submit']"));
        Thread.sleep(2000);
        submitButton.click();
        WebElement message=driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertEquals(BrowserUtils.getText(message),"Thanks for contacting us, we will get back to you shortly.");




    }
}
