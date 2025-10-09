package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.BaseClass;

public class TC_L4_Test  extends BaseClass{

	@Test
	public void emptyField() {
		logger.info("*** Strting Testin for TC_L4 ***");
		try {
		loginPage lp = new loginPage(driver);
		lp.clickLogin();
		logger.info("*** Verification for TC_L4 ***");
		Assert.assertEquals(true, lp.verifyEmpty());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Completed Testin for TC_L4 ***");
	}
}
