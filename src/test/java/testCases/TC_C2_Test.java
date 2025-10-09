package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.cartPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_C2_Test extends BaseClass {

	@Test
	public void verifyRemovingProduct() {
		logger.info("*** Starting Test Case: TC_C2 Verify Removing Product from Cart ***");
		try {
		//step1: Login	
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login successful with user: {}",p.getProperty("userName"));
		
		//Step2: Adding and Removing Product from Cart
		logger.info("Verify functionality for TC_C2: Removing a product from cart");
		HomePage hp = new HomePage(driver);
		hp.addToCart();
		cartPage cp = new cartPage(driver);
		cp.rmvItem();
		logger.info("Removing Product SuccessFull");
		logger.info("*** Test Case: TC_C2 Passed ***");
		}catch(Exception e) {
			logger.error("***Test Case: TC_C2 Failed  ***");
			logger.error("Error encountered during TC_C2 execution: {}",e.getMessage(),e);
			throw e;
		}finally{
			logger.info("*** Ending Test Case: TC_C2 ***");
		}
	}
}
