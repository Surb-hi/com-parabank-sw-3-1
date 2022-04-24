package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[text()='Register']"));

        //Verify the text ‘Signing up is easy!’
        String expectedMsg = "Signing up is easy!";

        String actualMsg= getTextFromElement(By.xpath("//h1[text()='Signing up is easy!']"));

        Assert.assertEquals("Signup page is not Display", actualMsg, expectedMsg);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //Enter First name
        sendTextToElement(By.xpath("//input[@name='customer.firstName']"),"surbhi");
        // Enter Last name
        sendTextToElement(By.xpath("//input[@name='customer.lastName']"),"patel");
        //Enter Address
        sendTextToElement(By.xpath("//input[@name='customer.address.street']"),"107 low street");
        //Enter City
        sendTextToElement(By.xpath("//input[@name='customer.address.city']"),"Birmingham");
        //Enter State
        sendTextToElement(By.xpath("//input[@name='customer.address.state']"),"East middlan");
        //Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"),"Bh17 8lv");
        //Enter Phone
        sendTextToElement(By.xpath("//input[@name='customer.phoneNumber']"),"07979057910");
        //Enter SSN
        sendTextToElement(By.xpath("//input[@name='customer.ssn']"),"123456789");
        //Enter Username
        sendTextToElement(By.xpath("//input[@name='customer.username']"),"surbhi3");
        //Enter Password
        sendTextToElement(By.xpath("//input[@name='customer.password']"),"surbhi123");
        //Enter Confirm password
        sendTextToElement(By.xpath("//input[@name='repeatedPassword']"),"surbhi123");
        //Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));

        //Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMsg = "Your account was created successfully. You are now logged in.";

        String actualMsg =getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));

        Assert.assertEquals("Invalid details", actualMsg, expectedMsg);

    }

    @After
    public void tearDown() {
        closebrowser();

    }
}
