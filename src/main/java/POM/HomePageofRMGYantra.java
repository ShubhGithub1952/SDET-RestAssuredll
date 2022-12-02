package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageofRMGYantra {
	
	//initialization
	public HomePageofRMGYantra(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//a[contains(text(),'Projects')]") private WebElement projectLinkText;
	//@FindBy(xpath = "//tr/td[1]") private WebElement projectIds;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") private WebElement logoutButton;
	
	//Utilization
	public WebElement getProjectLinkText() {
		return projectLinkText;
	}
	public void setProjectLinkText(WebElement projectLinkText) {
		this.projectLinkText = projectLinkText;
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	public void setLogoutButton(WebElement logoutButton) {
		this.logoutButton = logoutButton;
	}
	
	//Method for click on Projects link text
	public void clickOnProjectLinkText() {
    	projectLinkText.click();
    }
	
	
    //Method for Click on Logout link text
    public void clickOnLogoutLinkText() {
    	logoutButton.click();
    }
    
	
}
