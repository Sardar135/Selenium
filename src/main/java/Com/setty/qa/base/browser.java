package Com.setty.qa.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class browser {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/geckodriver");
		 WebDriver driver = new FirefoxDriver();
		 
		 driver.get("https://www.facebook.com/");
		 driver.findElement(By.id("u_0_2")).click();
		 Thread.sleep(2000);
		 
		 String win= driver.getWindowHandle();
		 
//		 for(String popup :driver.getWindowHandles()) //iterating on child windows
//		    {
		    driver.switchTo().window(win);
		   // System.out.println("Popup values: "+popup);
		    // Perform any operations on child window
		    //}
		 
		 WebElement a= driver.findElement(By.id("month"));
		
		 if(a.isEnabled()) {
			 System.out.println("Jan month has selected");
		 }else {
			 System.out.println("Jan was not yet selected");
		 }
		 
		WebElement fnmae= driver.findElement(By.name("firstname"));
		fnmae.sendKeys("8019990074");
		WebElement lname = driver.findElement(By.name("lastname"));
		lname.sendKeys("Test");
		WebElement mob= driver.findElement(By.name("reg_email__"));
		mob.sendKeys("1234567890");
		WebElement pass= driver.findElement(By.name("reg_passwd__"));
		pass.sendKeys("Test@123");
		
		
		 
		 
		//List<String > Month= driver.findElements(By.id("month"));
		
		 
//		 
		 Thread.sleep(2000);
//		 driver.findElement(By.id("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[2]/option[2]")).isSelected();
//		 driver.close();
		 driver.close();
	}

}
