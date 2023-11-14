package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Ordercompletedpage;
import testBase.BaseClass;

public class Loginuser extends BaseClass {
	
	@Test(groups= {"Regression","Sanity"})
	public void loginuser() {
		
		logger.info("*** start user login process ***");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginlinkclick();
		lp.credentials(rb.getString("userid"), rb.getString("password"));
		lp.loginsubmit();
		
		logger.info("User logged in successfully");
		//String exp= "My account - Customer info";
		//Assert.assertEquals(exp, actual);
		//System.out.println(actual);
		Ordercompletedpage order = new Ordercompletedpage(driver);
		order.logoff();
	
	}

}
