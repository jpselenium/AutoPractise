package ap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ap.base.TestBase;
import ap.util.Xls_reader;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//span[@class='shop-phone']//i[@class='icon-phone']")
	WebElement PhoneIcon;
	
	@FindBy(xpath="//img[contains(@class, 'logo img-responsive')]")
	WebElement HomeLogo;
	
	@FindBy(id="contact-link")
	WebElement ContactLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public String validateUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean ValidateHomeLogo() {
		return HomeLogo.isDisplayed();
	}
	
	public boolean ValidatePhoneIcon() {
		return PhoneIcon.isDisplayed();
	}
	
	
	public void ClickOnContactLink() {
		ContactLink.click();
	}
	
}
