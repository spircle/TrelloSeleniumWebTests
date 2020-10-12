package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void boardCreation() {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board().withBoardName("qa24 board").withTeamVisibility("private"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePage();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after,before+1);
        //personal boards count before, after
    }

}
