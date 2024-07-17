package com.thetestingacademy;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class idrive_proj {
    @Test

    public void idrive360testNavigation() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver  driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"IDrive® 360 - Sign in to your account");

        //2. Enter the username, password
        WebElement emailInputBox = driver.findElement(By.id("username"));
        emailInputBox.sendKeys("augtest_040823@idrive.com");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("123456");
        // Sing button clicks
        WebElement buttonsubmit = driver.findElement(By.id("frm-btn"));
        buttonsubmit.click();

        //3. Verify that Trial is fnished and current URL also

        try {
            Thread.sleep(15000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement error_msg = driver.findElement(By.className("id-card-title"));
        System.out.println(error_msg.getText());
        Assert.assertEquals(error_msg.getText(), "Your free trial has expired");

        //current URL also
        System.out.println("Homepage URL: "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");

        try {
            Thread.sleep(15000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
