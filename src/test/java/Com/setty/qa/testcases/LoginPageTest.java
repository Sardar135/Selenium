package Com.setty.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import Com.setty.qa.base.TestBase;
import Com.setty.qa.pages.LoginPage;
import Com.setty.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	TestUtil testutil;
	String sheetName = "logindetails";

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setup() throws IOException {

		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		
	}
	
	
	@DataProvider
	
	public Object[][] getlogindataTest() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getlogindataTest")
	
	public void validatingloginTest(String firstname, String email, String password) {

		loginpage.validatelogin(firstname, email, password);

	}
	@Test
	
	public void ValidatingtitleTest() {
		String Title = loginpage.validatetile();
		AssertJUnit.assertEquals(Title, "ProtoCommerce");
		
	}
	@Test ()
	public void ValidatingGenderTest() {
		String Gender = loginpage.Validatinggender();
		
		AssertJUnit.assertEquals(Gender, "Female", "Gender not yet selected properly");
		
		//assert.assertEquals(Gender, true);
	}
	@Test
	public void ValidatingshopbtnTest() throws IOException {
		loginpage.shoiping();
	}
	@AfterMethod
	public void TearDown() throws InterruptedException {

		//Thread.sleep(3000);

		driver.close();

	}

}
