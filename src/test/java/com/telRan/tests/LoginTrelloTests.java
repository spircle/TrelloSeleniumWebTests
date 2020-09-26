package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.isAvatarPresent()){
            app.logout();
        }
    }

    @Test
    public void loginAtlassanAccPositiveTest() throws InterruptedException {
        app.login("arturanisimov20031996@gmail.com","pisikaka17153");
        //er userLoggedIn (isAvatarPresent())
        Assert.assertTrue(app.isAvatarPresent());
        //is user correct
    }
    @Test
    public void negativeLoginAtlassianAccPositiveTest(){

    }



}
