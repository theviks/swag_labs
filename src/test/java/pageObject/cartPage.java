package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class cartPage extends BasePage{

	public cartPage(WebDriver driver){
		super(driver);
	}
	
	WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));
	/*-------------------------------------------Verify Removing a product from Cart-----------------------------------------------------------------*/
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement cartBtn;
	@FindBy(xpath="//button[contains(@id,'remove')]") List<WebElement> rmvBtn;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") WebElement cartCount;
	
	
	public void rmvItem() {
		cartBtn.click();
		
		for(WebElement rv:rmvBtn) {
			rv.click();
			break;
		}
		Assert.assertEquals(cartCount.getText(), "5");
	}
	
	/*------------------------------------------------Verify multiple items in cart-------------------------------------------------*/
	@FindBy(xpath="//button[contains(@class,'btn btn_primary btn_small btn_inventory ')]") List<WebElement> addToCartBtn;
	@FindBy(xpath="//div[@id='shopping_cart_container']//span") WebElement cartCt;
	
	public void addToCart() {
		for(WebElement atc : addToCartBtn) {
			atc.click();
			}
		
		myWait.until(ExpectedConditions.visibilityOf(cartCt));
	}
	public void verifyCartCount() {
		Assert.assertEquals(cartCt.getText(), "6");
	}
}
