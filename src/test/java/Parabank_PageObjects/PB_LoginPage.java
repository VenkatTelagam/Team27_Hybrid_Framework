package Parabank_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class PB_LoginPage {

		public WebDriver driver;
		public PB_LoginPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="username")
		WebElement txtUsername;
		
		@FindBy(name="password")
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement btnLogin;
		
		
		public void setUserName(String uname) {
			
			txtUsername.sendKeys(uname);
		}
		
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLoginbtn() {
			btnLogin.click();
		}
	}
	