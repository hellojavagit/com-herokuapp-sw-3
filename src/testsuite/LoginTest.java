package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //sending email field
        sendTextToElement(By.id("username"),"tomsmith");
        //sending password field
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //clicking loginButton
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        verifyTextMessages("ErrorMessage","Secure Area",By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));

    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //sending email field
        clickOnElement(By.id("username"));
        //sending password field
        clickOnElement(By.name("password"));
        //clicking on Login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']\n"));
        verifyTextMessages("Messages Doesnot Match","Your username is invalid!\n" +
                "×",By.xpath("//div[@id='flash']"));

    }
    @Test
    public void verifyThePasswordErrorMessage(){

        //sending email field
        sendTextToElement(By.id("username"),"tomsmith");
        //sending password field
        sendTextToElement(By.name("password"),"SuperSecretPassword");
        //clicking on Login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        verifyTextMessages("Password is not valid","Your password is invalid!\n" +
                "×",By.xpath("//div[@id='flash']"));
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
