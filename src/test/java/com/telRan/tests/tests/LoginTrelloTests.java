package com.telRan.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.header().isAvatarPresent()){
            app.header().logout();
        }
    }

    @Test
    public void loginAtlassanAccPositiveTest() throws InterruptedException {
        app.session().login("arturanisimov20031996@gmail.com","pisikaka17153");
        //er userLoggedIn (isAvatarPresent())
        Assert.assertTrue(app.header().isAvatarPresent());
        //is user correct
    }
}
