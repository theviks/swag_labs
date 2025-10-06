package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.checkOutPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_CH2 extends BaseClass {

	@Test
	public void verifyMandatoryField() {
		logger.info("*** Starting Test Case: TC_CH2 Verify CheckOut with First Name Blank***");
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
		
		logger.info("verify functionality for TC_CH1: Verifying Error for Empty Field");
		//Step3: Processing for checkOut
		checkOutPage cp = new checkOutPage(driver);
		cp.processCheckout("", "sfsdf", "sdf254");
		Assert.assertEquals(true, cp.vfMandatoryField());
	
		
		logger.info("*** Test Case: TC_CH2 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_CH2 Failed ***");
			logger.error("Error encountered during TC_CH2 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_CH2 ***");
		}
	}
}
