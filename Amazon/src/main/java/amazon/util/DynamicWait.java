package amazon.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicWait {

	static WebDriverWait wait=new WebDriverWait(Driver.driver, 10);

	public static void toBeclickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
}
