package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class kat_proj {
    @Test
    public void testVerifyFREETrial() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        WebElement clickButton= driver.findElement(By.id("btn-make-appointment"));
        clickButton.click();

        //id="txt-username"
        //txt-password
        //id="btn-login"
        WebElement userName=driver.findElement(By.id("txt-username"));
        userName.sendKeys("John Doe");

        WebElement password =driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton =driver.findElement(By.id("btn-login"));
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println(driver.getTitle());
        driver.quit();


    }
}
