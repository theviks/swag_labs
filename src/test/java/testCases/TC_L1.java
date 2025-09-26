package testCases;

import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.BaseClass;

public class TC_L1 extends BaseClass {

	@Test
	public void login() {
		logger.info("*** Testing started for TC_L1 ***");
		try {
		loginPage lp = new loginPage(driver);
		lp.enterUserName("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickLogin();
		logger.info("*** Verification for correct login credential ***");
		lp.loginVerification();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing Completed for TC_L1 ***");
	}
}
