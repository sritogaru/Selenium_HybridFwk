package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.OrderCheckout;
import pageObjects.OrderPaymentcheckout;
import pageObjects.Ordercompletedpage;
import pageObjects.RegPage;
import pageObjects.ShoppingContinuePage;
import pageObjects.Shoppingcart;
import testBase.BaseClass;
import utilities.TakeScreenshots;

public class AccountRegistration extends BaseClass {
	
	@Test(priority = 1, groups= {"Regression","Smoke"})
	public void UserReg() throws IOException {
		
		logger.info(" *** started User Registration and shopping process *** ");
		Homepage hp = new Homepage(driver);
		hp.Regbtnclick();
		RegPage rp = new RegPage(driver);
		rp.Genclick();
		rp.Regdetails(randomString(), randomString(), randomAlphaNumeric()+"@gmail.com", "Test@123", "Test@123");
		rp.Regclick();
		logger.info("User Registered");
	}   
	    @Test(priority = 2, groups= {"Regression","Smoke"})
		public void shoppingcontinue() {
		ShoppingContinuePage scp = new ShoppingContinuePage(driver);
		scp.continuebtn();
		scp.jewelrybtnclick();
		scp.Addtocartclick();
		scp.innerAddcartclick();
		scp.shoppingcartclick();
		}
	    @Test(priority = 3, groups= {"Regression","Smoke"})
		public void shoppingcartcheckout() {
		Shoppingcart shopcart = new Shoppingcart(driver);
		shopcart.discountcode("Automationdiscount2");
		shopcart.Applycouponcode();
		shopcart.termscheckbox();
		shopcart.checkoutbtn();
		OrderCheckout oc = new OrderCheckout(driver);
		oc.countryselection();
		oc.customerdetails(randomString(), randomString(), randomNumber(), randomNumber());
		logger.info("Provided user details");
		
		}
	    @Test(priority = 4, groups= {"Regression","Smoke"})
		public void paymentcheckout() {
		OrderPaymentcheckout opc = new OrderPaymentcheckout(driver);
		opc.Continuebtnsclick();
        opc.creditcardtypeselection();
        opc.carddetailsenter(randomString(), "23458567234545678", "555");
        logger.info("User entered card details");
        opc.expirymondate();
        opc.expiryyeardate();
        opc.paymentinfocontinue();
        opc.confirmorder();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //TakeScreenshots.screenshottake(driver, "ordercompleted");
        logger.info("confirmed order and captured order number in screenshot");
		}
	    @Test(priority = 5, groups= {"Regression","Smoke"})
		public void ordernumandlogout() {
        Ordercompletedpage order = new Ordercompletedpage(driver);
        String text= order.messageverify();
   	    String exptext= "Your order has been successfully processed!";
   	    Assert.assertEquals(text, exptext);
   	    System.out.println(text);
   	   String ordernumvalue = order.ordernum();
   	   System.out.println(ordernumvalue+ " " );
   	   order.logoff();
   	   logger.info("*** Finished shopping process and signed off ***");
   	 
		
		
		
		
		
	}

}
