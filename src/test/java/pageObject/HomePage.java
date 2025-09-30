package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/*-------------------------------------------------Verify All Products are displayed---------------------------------------------------*/
	@FindBy(xpath="//div[@class='inventory_item']") List<WebElement> products;
	
	public void verifyAllProductsDisplayes() {
		Assert.assertEquals(products.size(), 6);
		
		for(WebElement product : products) {
			String productName = product.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
			String productPrice = product.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
			WebElement image = product.findElement(By.xpath("//div[@class='inventory_item_img']"));
			
			Assert.assertFalse(productName.isEmpty(),"Product Name is Empty");
			Assert.assertTrue(productPrice.startsWith("$"),"Price is Wrong");
			Assert.assertEquals(true, image.isDisplayed());
		}
	}
	
	
	
	
}
