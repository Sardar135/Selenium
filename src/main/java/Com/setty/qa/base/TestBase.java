package Com.setty.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Com.setty.qa.util.TestUtil;
import Com.setty.qa.util.WebEventListener;



public class TestBase {
	public static WebDriver driver;
	public static  Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws IOException {

		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/admin/Desktop/eclipse-workspace/ProjectRahulsetty/src/main/java/Com/setty/Config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/admin/Desktop/geckodriver");
			driver = new FirefoxDriver();
		}
		
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		try {
			eventListener = new WebEventListener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//e_driver.register(eventListener);
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);

		// driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait,TimeUnit.SECONDS);
		//String url = prop.getProperty("URL");
		driver.get(prop.getProperty("URL"));

	}

	
}