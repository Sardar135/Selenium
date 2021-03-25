package Com.setty.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.setty.qa.base.TestBase;

public class LoginPage extends TestBase {

	private static final String String = null;

	
	//pagefactory or object repository
	@FindBy(name = "name") //username
	@CacheLookup
	WebElement user;

	@FindBy(name = "email")   //email id
	WebElement emailid;

	@FindBy(id = "exampleInputPassword1")   //pass
	WebElement password;

	@FindBy(id = "exampleCheck1")  //check
	WebElement checkbtn;

	@FindBy(id = "exampleFormControlSelect1")  //gender
	WebElement gender;
	
	@FindBy(id = "inlineRadio2")  //emply status
	WebElement emplystatus;
	
	@FindBy(xpath= "//a[contains(text(), 'Shop')]")
	WebElement shop;	
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//a[@class='close']")
	WebElement successcancelbtn;
	
	public LoginPage() throws IOException {   // initiating the webdriver to this method

		super();
		PageFactory.initElements(driver, this);

	}

	public void validatelogin(String userN, String Eid, String pass ) {   
		user.sendKeys(userN);
		emailid.sendKeys(Eid);
		password.sendKeys(pass);
		checkbtn.click();
		emplystatus.click();
		Select s = new Select(gender);
		s.selectByVisibleText("Female");
		gender.isDisplayed();
		submitbtn.click();
		

	}

	public String validatetile() {
		return driver.getTitle();
	}
	

	public String Validatinggender() {
		Select s = new Select(gender);
		s.selectByVisibleText("Female");
		gender.isDisplayed();
		return String;
		
		
	}
	public ShopPage shoiping() throws IOException {
		shop.click();
		return new ShopPage();
		
	}
	
	
	
}
