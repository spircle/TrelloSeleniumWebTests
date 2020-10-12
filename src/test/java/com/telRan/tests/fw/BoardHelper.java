package com.telRan.tests.fw;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }
    public void fillBoardForm(Board board) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.getBoardName());
        //team
        click(By.xpath("//*[@class='W6rMLOx8U0MrPx']"));
        click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]"));
        //public/private("" + teamVisible + "')
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getTeamVisibility() + "']/../.."));
        //confirmPublic
        if (board.getTeamVisibility().equals(("public"))) {
            click(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
        }
    }

    public void confirmBoardCreation() {
        click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
    }



    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

    public void clickOnFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(Board board) {
        click(By.cssSelector(".js-rename-board-input"));
        wd.findElement(By.cssSelector(".js-rename-board-input")).click();
        wd.findElement(By.cssSelector(".js-rename-board-input")).clear();
        wd.findElement(By.cssSelector(".js-rename-board-input"))
                .sendKeys(board.getBoardName() + Keys.ENTER);
    }
}
