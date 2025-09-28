package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.BaseClass;

public class TC_L3 extends BaseClass {

	@Test
	public void loginWithLockedUser() {
		logger.info("*** Starting Testing for TC_L3 ***");
		try {
		loginPage lp = new loginPage(driver);
		lp.enterUserName("locked_out_user");
		lp.enterPassword("secret_sauce");
		lp.clickLogin();
		logger.info("*** Verfiying for TC_L3 ***");
		Assert.assertEquals(true, lp.lockesVerify());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Finished Testing for TC_L3 ***");
	}
}
