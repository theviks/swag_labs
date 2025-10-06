package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
	/*------------------------------------------------Verifying order summary accuracy------------------------------------------------------*/
	@FindBy(xpath="//div[@class='summary_subtotal_label']") WebElement itemTotal;
	@FindBy(xpath="//div[@class='summary_tax_label']") WebElement tax;
	@FindBy(xpath="//div[@class='summary_total_label']") WebElement total;
	
	public void verifyOrderSummary() {
		String itmTotal = itemTotal.getText().replace("Item total: $", "").trim();
		String taxTotal = tax.getText().replace("Tax: $", "").trim();
		String finalTotal = total.getText().replace("Total: $", "").trim();
		
		Assert.assertEquals(itmTotal, "129.94");
		Assert.assertEquals(taxTotal, "10.40");
		Assert.assertEquals(finalTotal, "140.34");
	}
	
	/*-----------------------------------------------------Verify Successful order completion-----------------------------------------------*/
	@FindBy(xpath="//button[@id='finish']") WebElement finishOrderBtn;
	@FindBy(xpath="//h2[normalize-space()='Thank you for your order!']") WebElement verifyMessage;
	
	public boolean vfMessage() {
		finishOrderBtn.click();
		return verifyMessage.isDisplayed();
	}
 	
}
