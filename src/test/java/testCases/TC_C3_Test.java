package testCases;

import org.testng.annotations.Test;

import pageObject.cartPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_C3_Test extends BaseClass{

	@Test
	public void verifyAddingMultipleProduct() {
		logger.info("*** Starting Test Case: TC_C3 Verify adding Multiple product to cart ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Product and add then to cart
		logger.info("verify functionality for TC_C3: Verify adding Multiple product to cart");
		cartPage cp = new cartPage(driver);
		cp.addToCart();
		cp.verifyCartCount();
		logger.info("Cart count displayed correctly");
		logger.info("*** Test Case: TC_C3 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_C3 Failed ***");
			logger.error("Error encountered during TC_C3 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_C3 ***");
		}
	}
}
