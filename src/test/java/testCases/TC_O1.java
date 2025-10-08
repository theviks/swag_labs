package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_O1 extends BaseClass {

	@Test
	public void veifyUserLogout() {
		logger.info("*** Starting Test Case: TC_CH4 Verify User can Logout ***");
		try {
			//Step1: login
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successful with user: {}",p.getProperty("userName"));
		
		//Step2: Navigate to Ham-Burger Menu 
		logger.info("verify functionality for TC_O1: Pressing Logout Button");
		HomePage hp = new HomePage(driver);
		hp.logOut();
		
		
		logger.info("verify functionality for TC_O1: Verifying user Loged Out successfully ");
		Assert.assertEquals(true, hp.vfLogOut());	
		
		logger.info("*** Test Case: TC_O1 Passed ***");
		}catch(Exception e) {
			logger.error("*** Test Case: TC_O1 Failed ***");
			logger.error("Error encountered during TC_O1 execution: {}",e.getMessage(),e);
			throw e;
		}finally {
			logger.info("*** Ending Test Case: TC_O1 ***");
		}
	}
}
