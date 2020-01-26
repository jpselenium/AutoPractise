package ap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ap.base.TestBase;
import ap.util.Xls_reader;

public class ContactPage extends TestBase{

	
	@FindBy(id="id_contact")
	WebElement contactId;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="message")
	WebElement message;
	
	
	@FindBy(xpath="//button[@name='submitMessage']")
	WebElement sbtBtn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createMessage(String title, String emailAddress, String meesageDetail) {
		
		Select select = new Select(driver.findElement(By.id("id_contact")));
		select.selectByVisibleText(title);
		
		email.clear();
		email.sendKeys(emailAddress);		
		message.sendKeys(meesageDetail);		
	}
	
	
	public void verifyMessage()
	{
		Xls_reader reader = new Xls_reader("C:\\Users\\Swami\\eclipse-workspace\\AutoPractices\\src\\main\\java\\ap\\testdata\\CreatMessage.xlsx");
		
		String sheetName = "message";
		
		int rowCount = reader.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			String title = reader.getCellData(sheetName, "title", rowNum);
			String emailAddress = reader.getCellData(sheetName, "email", rowNum);
			String messageDetail = reader.getCellData(sheetName, "message", rowNum);

			System.out.println(title);
			System.out.println(emailAddress);
			System.out.println(messageDetail);
		
			Select select = new Select(driver.findElement(By.id("id_contact")));
			select.selectByVisibleText(title);
			
			email.clear();
			email.sendKeys(emailAddress);			
			message.sendKeys(messageDetail);
			sbtBtn.click();
	}
	}
	
		// Xls_reader reader = new Xls_reader("C:\Users\Swami\eclipse-workspace\AutoPractices\src\main\java\ap\testdata\CreatMessage.xlsx");
		// String sheetName = "message";
		
		// int rowCount = reader.getRowCount(sheetName);
		
	
	
}
