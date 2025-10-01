package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC_P2 extends BaseClass {

	@Test
	public void aToZsorting() {
		
		loginPage lp = new loginPage(driver);
		lp.enterUserName(p.getProperty("userName"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		HomePage hp = new HomePage(driver);
		hp.vf();
		
		
		
	}
}
