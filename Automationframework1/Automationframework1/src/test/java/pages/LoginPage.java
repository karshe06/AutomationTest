package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Enter your User ID']")
    private WebElement userIdInput;

    @FindBy(xpath = "//input[@placeholder='Enter your Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root')]")
    private WebElement passwordToggle;

    @FindBy(xpath= "//div[contains(text(), 'To proceed to the login page please allow 'Notifications' and then click 'Reload' to continue.')]")

    private WebElement errorMessage;
    
    @FindBy(xpath="//input[@placeholder='Enter your Password']/following-sibling::button']")
    private WebElement passwordunmasking;
    
     

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Getters
    public void enterUserId(String userId) {
        userIdInput.clear();
        userIdInput.sendKeys(userId);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public void togglePasswordVisibility() {
        passwordToggle.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getPasswordFieldType() {
        return passwordInput.getAttribute("type");
    }

	public WebElement getPasswordToggle() {
		return passwordToggle;
	}

	public void setPasswordToggle(WebElement passwordToggle) {
		this.passwordToggle = passwordToggle;
	}

	public WebElement getPasswordunmasking() {
		return passwordunmasking;
	}

	public void setPasswordunmasking(WebElement passwordunmasking) {
		this.passwordunmasking = passwordunmasking;
	}
    
    
}
