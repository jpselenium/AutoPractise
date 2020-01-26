package ap.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ap.base.TestBase;
import ap.pages.ContactPage;
import ap.pages.HomePage;
import ap.pages.LoginPage;
import ap.util.TestUtil;



public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@DataProvider
	public  Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.GetDataFromExcel();
		return testData.iterator();
	}
	
	
	/*
	@Test
	public void validateLogo() {
		boolean flag = homePage.ValidateHomeLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test
	public void validatePhoneIcon() {
		boolean flag = homePage.ValidatePhoneIcon();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateTitle() {
		String title = homePage.validateTitle();
		Assert.assertEquals(title, "My Account - My Store");
	} */
	
	/*
	@Test
	public void validateMessage() {
		homePage.ClickOnContactLink();
		contactPage = new ContactPage();
		contactPage.verifyMessage();
		//contactPage.createMessage("Customer service", "trainerjp4u@gmail.com", "need to cancel order");		
		
	} */
	
	@Test(dataProvider="getTestData")
	public void varifyMessage(String title, String email, String message) {
		homePage.ClickOnContactLink();
		
		Select select = new Select(driver.findElement(By.id("id_contact")));
		select.selectByVisibleText(title);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);			
		driver.findElement(By.id("message")).sendKeys(message);
		//sbtBtn.click();
		
	}
	
	/*
	
	@AfterMethod	
	public void close() {
		driver.quit();		
	}  
	
	*/
}
