package pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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
	
	/*-------------------------------------------------Verify Sorting Functionality A-Z ---------------------------------------------------*/
	@FindBy(xpath="//div[@class='right_component']") WebElement filter;
	@FindBy(xpath="//select[@class='product_sort_container']") WebElement filterOptions;
	@FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> pNames;
	public void vf() {
		filter.click();
		Select sc = new Select(filterOptions);
		sc.selectByValue("az");
		
		List<String> actualNames = new ArrayList<>();
		for(WebElement pN : pNames) {
			actualNames.add(pN.getText());
		}
		
		List<String> expectedNames = new ArrayList<>(actualNames);
		Collections.sort(expectedNames);
		Assert.assertEquals(actualNames, expectedNames,"Names are not sorted properly");
		
	}
	
}
