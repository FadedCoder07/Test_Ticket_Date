package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestBiletKontrol 
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() throws IOException 
    {
        
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void testBilet() throws IOException, InterruptedException {
    
        driver.get(Constants.BASE_URL1);
    
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

        WebElement fromTrainInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromTrainInput")));
    
        fromTrainInput.sendKeys("Ankara"); 
    
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gidis-2503")));
        dropdownButton.click();
    
    
        Thread.sleep(10000); 
    
    
        if (driver != null) {
            driver.quit();
        }
    }
    
}
