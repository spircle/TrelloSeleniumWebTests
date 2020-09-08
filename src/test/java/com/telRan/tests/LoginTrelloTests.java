package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        login("arturanisimov20031996@gmail.com","pisikaka17153");
        //er userLoggedIn (isAvatarPresent())
        Assert.assertTrue(isAvatarPresent());
        //is user correct
    }


    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email);
        Thread.sleep(5000);
        click(By.id("login"));
        Thread.sleep(5000);
        type(By.id("password"), password);
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }
    public boolean isAvatarPresent() {
        return wd.findElements(By.xpath("//button[@data-test-id='header-member-menu-button']")).size() > 0;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
