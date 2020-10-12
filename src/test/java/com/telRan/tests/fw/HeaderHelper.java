package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }
    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }
    public void selectCreateTeam() {
        click(By.xpath("//button[@data-test-id='header-create-team-button']"));
    }

    public void returnOnHomePage() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }
    public void returnOnHomeFromTeam() {
        click(By.cssSelector("[data-test-id='header-home-button']"));
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

    public boolean isAvatarPresent() {
        return wd.findElements(By.xpath("//button[@data-test-id='header-member-menu-button']")).size() > 0;
    }
}
