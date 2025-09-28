package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginPage extends BasePage{

	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='user-name']") WebElement userName;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//input[@id='login-button']") WebElement loginBtn;
	@FindBy(xpath="//span[@class='title']") WebElement verify;
	
	public void enterUserName(String usrN) {
		userName.sendKeys(usrN);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public boolean loginVerification() {
		return verify.isDisplayed();
	}
	
	/*--------------------Invalid Password-----------------------------*/
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match a')]") WebElement verifyWrongPass;
	public boolean verifyPass() {
		return verifyWrongPass.isDisplayed();
	}
	/*----------------------Locked Out User----------------------------*/
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]") WebElement verifyLockedUser;
	public boolean lockesVerify() {
		return verifyLockedUser.isDisplayed();
	}
	/*----------------------Empty Fields--------------------------------*/
	@FindBy(xpath="//h3[normalize-space()='Epic sadface: Username is required']") WebElement emptyVerify;
	public boolean verifyEmpty() {
		return emptyVerify.isDisplayed();
	}
}
