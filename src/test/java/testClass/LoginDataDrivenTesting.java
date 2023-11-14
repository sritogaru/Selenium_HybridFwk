package testClass;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;
import utilities.DataProviderUtility;
import utilities.ExcelUtility;


public class LoginDataDrivenTesting extends BaseClass {
	


	@Test(dataProvider="DataDriven", dataProviderClass=DataProviderUtility.class) // we need to mention dataprovider utility class.class
	public void logindatadriven(String id, String password, String expected) {
		
      logger.info("*** start user login process ***");
		
		try {
			LoginPage lp = new LoginPage(driver);
			lp.loginlinkclick();
			lp.credentials(id, password);
			lp.loginsubmit();
			
			logger.info("User logging started successfully");
			
			Myaccountpage map = new Myaccountpage(driver);
			map.myaccountclick();
			boolean target = map.myaccountdetailsdisplayed();
			if(expected.equals("valid")) {
				if(target==true) {
					  map.logout();
					  Assert.assertTrue(true);
				}
				
				else {
					Assert.assertTrue(false);
				}
			}
			if(expected.equals("invalid")) {
				if(target==false) {
					 map.logout();
					  Assert.assertTrue(false);
				}
			
				else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	    logger.info("Data Driven Tests completed successfully");
		}}
		



	



