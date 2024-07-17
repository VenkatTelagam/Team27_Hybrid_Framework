package ParaBank_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingData {
	
	
	Properties pro;
	public ReadingData() {
		File file=new File("./Configuration/Data.properties");
		
		try {
			//it is coverting any file in reaading mode
			FileInputStream fis=new FileInputStream(file);
			
			pro=new Properties();
			pro.load(fis);//loading the properties file
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getFirstName() {
		
		 String FName=pro.getProperty("FirstName");
		 return FName;
	}
	
	public String getLastName() {
		String LName=pro.getProperty("LastName");
		return LName;
	}
	
	public String getAddress() {
		String add=pro.getProperty("Address");
	    return add;
	}
	public String getCity() {
		String city=pro.getProperty("city");
		return city;
	}
	
	public String getState() {
		String state=pro.getProperty("state");
		return state;
	}
	
	public String getZipcode() {
		
		String ZCode=pro.getProperty("Zipcode");
		return ZCode;
	}
	
	public String  getPhoneNo() {
		
		String PHNo=pro.getProperty("Phonenumber");
	    return PHNo;
	}
	
	public String getSSN() {
		
		String ssn=pro.getProperty("SSN");
		return ssn;
	}
	
	public String getUsername() {
		String uname=pro.getProperty("Username");
		return uname;
	}
	
	public String getPassword() {
		String pword=pro.getProperty("password");
		return pword;
	}
	
	public String getCpword() {
		
		String cpword=pro.getProperty("ConfirmPassword");
		return cpword;
	}

}
