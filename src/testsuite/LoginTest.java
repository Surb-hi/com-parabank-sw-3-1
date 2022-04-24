package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"surbhi3");
        //Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"surbhi123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the ‘Accounts Overview’ text is display
        String expectedMsg = "Accounts Overview";

        String actualMsg = getTextFromElement(By.xpath("//h1[text()='Accounts Overview']"));

        Assert.assertEquals("Invalid account details", actualMsg, expectedMsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        sendTextToElement(By.xpath("//input[@name='username']"),"prime");
        //Enter invalid password
        sendTextToElement(By.xpath("//input[@name='password']"),"prime12");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the error message ‘The username and password could not be verified.’
        String expectedMsg = "The username and password could not be verified.";

        String actualMsg=getTextFromElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));

        Assert.assertEquals("Invalid details", actualMsg, expectedMsg);

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"surbhi2");
        //Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"surbhi123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        //Verify the text ‘Customer Login
        String expectedMsg = "Customer Login";

        String actualMsg=getTextFromElement(By.xpath("//h2[text()='Customer Login']"));

        Assert.assertEquals("Invalid account details", actualMsg, expectedMsg);
    }

    @After
    public void tearDown() {
        closebrowser();
    }
}


