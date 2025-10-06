package testCases;

import org.testng.annotations.Test;

import pageObject.cartPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_C4 extends BaseClass{

	@Test
	public void verifyCartDetails() {
		logger.info("*** Starting Test Case: TC_C4 Verify Cart Page display Items Correctly ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Product and add then to cart
		logger.info("verify functionality for TC_C4: Verify adding Multiple product to cart");
		cartPage cp = new cartPage(driver);
		cp.addToCart();
		cp.prodcutDetails();
		
		logger.info("Cart displayed all product correctly");
		logger.info("*** Test Case: TC_C4 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_C4 Failed ***");
			logger.error("Error encountered during TC_C4 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_C4 ***");
		}
	}
}
