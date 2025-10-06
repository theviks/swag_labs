package testCases;


import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.checkOutPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_CH3 extends BaseClass {

	@Test
	public void verifyOrderSummary() {
		logger.info("*** Starting Test Case: TC_CH3 Verify Order Summary ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Product and add then to cart
		logger.info("verify functionality for TC_CH3: Adding Multiple product to cart");
		HomePage hp = new HomePage(driver);
		hp.addProductToCart();
		hp.cartPage();
		
		logger.info("verify functionality for TC_CH3: Verifying Summary");
		//Step3: Processing for checkOut
		checkOutPage cp = new checkOutPage(driver);
		cp.processCheckout("sdf", "sfsdf", "sdf254");
		cp.verifyOrderSummary();
	
		logger.info("*** Test Case: TC_CH3 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_CH3 Failed ***");
			logger.error("Error encountered during TC_CH3 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_CH3 ***");
		}
	}
}
