package ParaBank_Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ParaBank_Utilities.XLUtils;
import Parabank_PageObjects.PB_LoginPage;

public class PB_TC_002_LoginTest_DataDriven extends PB_BaseClass {

	
	@Test(dataProvider="LoginData")
	public void loginTest(String UN,String PWD) {
		
		PB_LoginPage lp=new PB_LoginPage(driver);
		
		lp.setUserName(UN);
		lp.setPassword(PWD);
		lp.clickLoginbtn();
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path="F:\\Eclipse work space\\Hybrid_Framework\\src\\test\\java\\ParaBank_TestData\\LoginData.xlsx";
		
		//it is identify the rowcount
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		//identify the colcount
		int colcount=XLUtils.getCellcount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		//0,1
		for(int i=1;i<=rownum;i++) {//it is represents rows
			
			for(int j=0;j<colcount;j++) {//it is represents the columns
				
				logindata[i-1][j]=XLUtils.getcelldata(path, "Sheet1", i, j);
			}
			
		}
		return logindata;
	}
	
}
