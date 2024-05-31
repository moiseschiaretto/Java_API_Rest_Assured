package com.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestWeb {
    public String baseUrl = "https://bradescosaudeconvenios.com.br";
    public WebDriver driver;
    
    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }
    
    @Test(priority=1, enabled = true)
    public void verifyTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Bradesco Saúde"));
        
        String expectedTitle = "Bradesco Saúde";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        assert actualTitle.contains(expectedTitle) : "Title verification failed!";
    }
    
    @AfterTest
    public void endSession() {
        driver.quit();
    }
}
