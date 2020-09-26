package com.telRan.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        //Create new instance of WebDriver(ex. open ChromeBrowser)
        app.init();
        app.login("arturanisimov20031996@gmail.com", "pisikaka17153");

    }

    @AfterClass(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
