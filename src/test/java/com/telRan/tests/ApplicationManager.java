package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        //open site
        wd.navigate().to("https://trello.com/");
    }

    public void stop() {
        wd.quit();
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
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

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAvatarPresent() {
        return wd.findElements(By.xpath("//button[@data-test-id='header-member-menu-button']")).size() > 0;
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));

    }

    public void fillBoardForm(String boardName, String teamVisible) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
        //team
        click(By.xpath("//*[@class='W6rMLOx8U0MrPx']"));
        click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]"));
        //public/private("" + teamVisible + "')
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + teamVisible + "']/../.."));
        //confirmPublic
        if (teamVisible.equals(("public"))) {
            click(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
        }
    }

    public void confirmBoardCreation() {
        click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
    }

    public void returnOnHomePage() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }
}
