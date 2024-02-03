package POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.CRM.SDET37.GenericUtility.IConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginVerifyThenLogout {


	public void loginToPageThenVerifyandLogout(String projId) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(IConstants.rmgURL);
		LoginPageOfRMGYantra loginPageRef = new LoginPageOfRMGYantra(driver);
		loginPageRef.signIntoRMGYantra(IConstants.appUserName, IConstants.appPassword);

		HomePageofRMGYantra homePageRef = new HomePageofRMGYantra(driver);
		homePageRef.clickOnProjectLinkText();

		List<WebElement> allProjIds = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag=false;
		for (WebElement ProjectID : allProjIds) {
			String ActualprodID = ProjectID.getText();
			if (ActualprodID.contains(projId)) {
				flag=true;
				break;
			}
		}
		if (flag==true) {
			System.out.println("=========>> Project is Present in Presentation Layer  <<===========");
		}else {
			System.out.println("=========>> Project is not Present in Presentation Layer  <<===========");
		}
		
		homePageRef.clickOnLogoutLinkText();
		
		driver.quit();
	}
}
