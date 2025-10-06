package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.checkOutPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_CH1 extends BaseClass {

	@Test
	public void verifyCheckOut() {
		logger.info("*** Starting Test Case: TC_CH1 Verify CheckOut with Valid details ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Product and add then to cart
		logger.info("verify functionality for TC_CH1: Adding Multiple product to cart");
		HomePage hp = new HomePage(driver);
		hp.addProductToCart();
		hp.cartPage();
		
		//Step3: Processing for checkOut
		checkOutPage cp = new checkOutPage(driver);
		cp.processCheckout("sdfas", "sfsdf", "sdf254");
		
		logger.info("verify functionality for TC_CH1: Verifying order summary page displayed");
		cp.vfCheckOut();
	
		logger.info("Order Summary page displayed");
		logger.info("*** Test Case: TC_CH1 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_CH1 Failed ***");
			logger.error("Error encountered during TC_CH1 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_CH1 ***");
		}
	}
}
