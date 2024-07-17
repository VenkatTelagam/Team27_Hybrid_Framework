package Parabank_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_RegistrationPage {
	public WebDriver driver;
	//it is divided into 3 parts
	public PB_RegistrationPage(WebDriver driver) {

		this.driver=driver;

		PageFactory.initElements(driver, this);
	}

	//identify the WebElements
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;

	@FindBy(id="customer.firstName")
	WebElement txtFirstname;

	@FindBy(id="customer.lastName")
	WebElement txtLastname;

	@FindBy(id="customer.address.street")
	WebElement txtAddress;

	@FindBy(id="customer.address.city")
	WebElement txtCity;

	@FindBy(id="customer.address.state")
	WebElement txtState;

	@FindBy(id="customer.address.zipCode")
	WebElement txtZipcode;

	@FindBy(id="customer.phoneNumber")
	WebElement txtPhoneno;

	@FindBy(id="customer.ssn")
	WebElement txtSSN;

	@FindBy(id="customer.username")
	WebElement txtUsername;

	@FindBy(id="customer.password")
	WebElement txtPassword;

	@FindBy(id="repeatedPassword")
	WebElement txtCPassword;

	@FindBy(xpath="(//input[@type='submit'])[2]")
	WebElement btnRegister;


	//create the corresponding actions

	public void ClickRegisterLink() {
		lnkRegister.click();
	}

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String Lname) {
		txtLastname.sendKeys(Lname);
	}

	public void setAddress(String add) {
		txtAddress.sendKeys(add);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setState(String state) {
		txtState.sendKeys(state);
	}

	public void setZipcode(String zcode) {
		txtZipcode.sendKeys(zcode);
	}

	public void setPhoneNumber(String phno) {

		txtPhoneno.sendKeys(phno);
	}

	public void setSSN(String ssn) {

		txtSSN.sendKeys(ssn);
	}

	public void setUsername(String Uname) {

		txtUsername.sendKeys(Uname);
	}

	public void setPassword(String pword) {

		txtPassword.sendKeys(pword);
	}

	public void setConfirmPassword(String Cpword) {

		txtCPassword.sendKeys(Cpword);
	}

	public void clickRegisterBtn() {
		btnRegister.click();
	}

}
