package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;
    @BeforeClass
   public void setUp(){
        //Create new instance of WebDriver(ex. open ChromeBrowser)
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

   }

    @Test
    public void loginAtlassanAccPositiveTest() throws InterruptedException {
        //clickOnLogInButtonWelcomePage
        wd.findElement(By.cssSelector("[href='/login']")).click();

        //fillLoginForm
            //fillEmail
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("arturanisimov20031996@gmail.com");
            //wait
        Thread.sleep(5000);

            //clickOnLoginWithAtlassianButton
        wd.findElement(By.id("login")).click();
        Thread.sleep(5000);
            //fillPassword
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("pisikaka17153");
            //confirmLogIn
        wd.findElement(By.id("login-submit")).click();
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
