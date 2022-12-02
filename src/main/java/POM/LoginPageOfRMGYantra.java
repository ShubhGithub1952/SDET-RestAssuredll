package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOfRMGYantra {
    // initialization
	public LoginPageOfRMGYantra(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name = "username") private WebElement userNameTextField;
	@FindBy(name  = "password") private WebElement passwordTextField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement signInButton;
	
	//Utilization
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public void setUserNameTextField(WebElement userNameTextField) {
		this.userNameTextField = userNameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	public WebElement getSignInButton() {
		return signInButton;
	}
	public void setSignInButton(WebElement signInButton) {
		this.signInButton = signInButton;
	}
	
	public void signIntoRMGYantra(String userName, String password) {
		userNameTextField.clear();
		userNameTextField.sendKeys(userName);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		signInButton.click();
	}
	
}
