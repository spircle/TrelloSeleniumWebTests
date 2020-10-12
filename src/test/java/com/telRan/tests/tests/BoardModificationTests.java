package com.telRan.tests.tests;
import com.telRan.tests.model.Board;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest(){
        //enter to first
        app.board().clickOnFirstBoard();
        //change name
        app.board().renameBoard(new Board().withBoardName("renameBoard"));
    }
}
