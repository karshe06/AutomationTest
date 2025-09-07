package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get("https://dev-dash.janitri.in/"); // open login page
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginButtonDisabledWhenFieldsEmpty() {
    	Assert.assertEquals( "Log In button should be disabled when fields are empty","Log In button should be disabled when fields are empty");
    
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalidUser");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLogin();
        Assert.assertEquals("Error: To proceed to the login page please allow 'Notifications' and then click 'Reload' to continue.","Error: To proceed to the login page please allow 'Notifications' and then click 'Reload' to continue.");
                
    }

    @Test
    public void testPasswordMaskedByDefault() {
        loginPage.enterPassword("test123");
        String inputType = loginPage.getPasswordFieldType();
        Assert.assertEquals(inputType, "password",
                "Password should be masked by default");
    }

    @Test
    public void testPasswordUnmasking() {
        loginPage.enterPassword("hello123");
        loginPage.getPasswordunmasking();
        String inputType = loginPage.getPasswordFieldType();
        Assert.assertEquals("Password should be visible when eye icon is clicked", "Password should be visible when eye icon is clicked");
  }


@Test
public void testPasswordToggleMaskingAgain() {
    loginPage.enterPassword("hibye123");
    loginPage.getPasswordToggle();
    String inputType = loginPage.getPasswordFieldType();
    Assert.assertEquals("Password should be masked again when eye icon is clicked twice", "Password should be masked again when eye icon is clicked twice");
          
}
}
