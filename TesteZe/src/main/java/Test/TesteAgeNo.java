package Test;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteAgeNo {

	public static WebElement btnbx_Age(WebDriver driver) {
		WebElement element = null;
		try {
			element = driver.findElement(By.id("age-gate-button-no"));
		} catch (Exception e) {
			
			System.out.println("O elemento nao foi encontrado " + e.getMessage());
		}
		return element;
	}
}