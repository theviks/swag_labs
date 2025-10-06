package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends BasePage {

	public checkOutPage(WebDriver driver) {
		super(driver);
	}
	
	/*-----------------------------------------Verify CheckOut with valid details------------------------------------------------------------*/
	@FindBy(xpath="//button[@id='checkout']") WebElement checkOutBtn;
	@FindBy(xpath="//input[@id='first-name']") WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") WebElement postalCode;
	@FindBy(xpath="//input[@id='continue']") WebElement continueBtn;
	
	@FindBy(xpath="//span[@class='title']") WebElement verifyCheckOut;
	@FindBy(xpath="//h3[normalize-space()='Error: First Name is required']") WebElement verifyMandatoryField;
	
	public void processCheckout(String fName,String lName,String pCode) {
		checkOutBtn.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
		continueBtn.click();
	}
	
	public boolean vfCheckOut() {
		return verifyCheckOut.isDisplayed();
	}
	
	public boolean vfMandatoryField() {
		return verifyMandatoryField.isDisplayed();
	}
}
