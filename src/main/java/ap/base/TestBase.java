package ap.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream f1 = new FileInputStream("C:\\Users\\Swami\\eclipse-workspace\\AutoPractices\\src\\main\\java\\ap\\configs\\config.properties");
		prop.load(f1);
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();	
	}	
		
	}
	
	public void initialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Swami\\Desktop\\SeleniumDivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		  
		String url = prop.getProperty("url");
		driver.get(url);
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
	}
}
