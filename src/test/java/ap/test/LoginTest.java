package ap.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ap.base.TestBase;
import ap.pages.HomePage;
import ap.pages.LoginPage;

public class LoginTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();		
	}
	
	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod	
	public void close() {
		driver.quit();		
	}  
	
}
