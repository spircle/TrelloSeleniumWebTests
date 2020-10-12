package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
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
}
