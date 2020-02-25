package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteMain {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get("https://www.ze.delivery/");
		
		TesteAge.btnbx_Age(driver);
		TesteAgeNo.btnbx_Age(driver);
		

	}
	
}
