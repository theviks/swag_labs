package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_P1 extends BaseClass {

	@Test
	public void prodctListVerification(){
		
		logger.info("*** Starting Testing for TC_P1 ***");
		try {
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("*** Checking all products displayed for TC_P1 ***");
		HomePage hp = new HomePage(driver);
		hp.verifyAllProductsDisplayes();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Completed Testing for TC_P1 ***");
	}
}
