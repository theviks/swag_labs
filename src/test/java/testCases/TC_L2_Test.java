package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.BaseClass;

public class TC_L2_Test extends BaseClass {

	@Test
	public void loginWithInvalidPassword() {
		logger.info("*** Starting testing for TC_L2 ***");
		try {
		loginPage lp = new loginPage(driver);
		lp.enterUserName("standard_user");
		lp.enterPassword("asfdasfass");
		lp.clickLogin();
		logger.info("*** Verification for TC_L2 ***");
		Assert.assertEquals(true, lp.verifyPass());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Finished testing for TC_L2 ***");
	}
}
