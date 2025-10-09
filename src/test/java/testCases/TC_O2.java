package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_O2 extends BaseClass {

	@Test
	public void verifySessionAfterLogout() {
		logger.info("*** Starting Test Case: TC_O2 Verify Session after  Logout ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		//Step2: Navigate to Ham-Burger Menu 
		logger.info("verify functionality for TC_O2: Pressing Logout Button");
		HomePage hp = new HomePage(driver);
		hp.logOut();
		
		driver.navigate().back();
		
		logger.info("verify functionality for TC_O2: Verifying session after logout");
		Assert.assertEquals(true, hp.vfSession());	
		
		logger.info("*** Test Case: TC_O2 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_O2 Failed ***");
			logger.error("Error encountered during TC_O2 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_O2 ***");
		}
	}
}
