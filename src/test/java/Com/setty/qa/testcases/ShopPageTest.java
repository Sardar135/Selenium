package Com.setty.qa.testcases;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Com.setty.qa.base.TestBase;
import Com.setty.qa.pages.AddCardPage;
import Com.setty.qa.pages.LoginPage;
import Com.setty.qa.pages.ShopPage;

public class ShopPageTest extends TestBase {

	LoginPage loginpage;
	ShopPage shoppage;
	AddCardPage addcardpage;

	public ShopPageTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setup() throws IOException {

		initialization();
		loginpage = new LoginPage();
		shoppage = loginpage.shoiping();
		addcardpage = shoppage.validatingaddcartbtn();

	}

	@Test()
	public void categorybtn1Test() throws IOException {
		loginpage =shoppage.validatingcategiry1();
	
	}
	@Test
	public void cetegorybtn2Test() throws IOException {
		loginpage = shoppage.validatingcategory2();
	}

	@Test 
	public void AddCartTest() throws IOException {
		addcardpage = shoppage.validatingaddcartbtn();
		assertNotEquals(addcardpage, true, "add to cart page is not opened");
		
		
	}
	@AfterMethod

	public void teardown() {
		driver.close();
	}

}
