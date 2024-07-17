package ParaBank_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Parabank_PageObjects.PB_RegistrationPage;

public class PB_TC_001_Register extends PB_BaseClass {

	public PB_RegistrationPage rp;
	
	@Test
	public void Registertest() throws IOException {
		
		rp=new PB_RegistrationPage(driver);
		
		rp.ClickRegisterLink();
		log.info("register link clicking activity is completed");
		rp.setFirstName(FName);
		log.info("first name is entered");
		rp.setLastName(LName);
		log.info("last name is enterd");
		rp.setAddress(Add);
		log.info("address added");
		rp.setCity(city);
		log.info("city name mentioned");
		rp.setState(state);
		rp.setZipcode(ZPcode);
		rp.setPhoneNumber(Phno);
		
		rp.setSSN(Ssn);
		rp.setUsername(UName);
		rp.setPassword(PWOrd);
		rp.setConfirmPassword(CPword);
		rp.clickRegisterBtn();
		
		
		String Act_title=driver.getTitle();
		String Exp_title="ParaBank | Customer Created";
		
		if(Act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);
			System.out.println("testcases is passed");
		}else {
			
			
			Assert.assertTrue(false);
			System.out.println("Testcase is failed");
		}
			
	}
}	