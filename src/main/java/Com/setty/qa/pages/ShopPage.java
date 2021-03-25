package Com.setty.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.setty.qa.base.TestBase;

public class ShopPage extends TestBase{

	
	
	
	@FindBy(xpath= "//a[contains(text(), 'Category 1')]")
	WebElement category1;
	
	@FindBy(xpath = "//a[contains(text(), 'Category 2')]")
	WebElement category2;
	
	@FindBy(xpath= "//a[contains(text(), 'Category 3')]")
	WebElement category3;
	
	@FindBy(xpath = "//a[contains(text(), 'ProtoCommerce Home')]")
	WebElement backloginpage;
	
	@FindBy(xpath = "//a[contains(text(), 'Checkout ( 0 )')]")
	WebElement checkoutbtn;
	
	@FindBy(xpath= "//button[contains(text(),'Add')]")
	WebElement addbtn;
	
	
	public ShopPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	
	public LoginPage validatingcategiry1 () throws IOException {
		category1.click();
		return new LoginPage();
	}
	
	public LoginPage validatingcategory2() throws IOException {
		category2.click();
		return new LoginPage();
	}
	
	public AddCardPage validatingaddcartbtn() throws IOException{
		 addbtn.click();
		 return  new AddCardPage();
		
		 
	}
	
	
	
}
