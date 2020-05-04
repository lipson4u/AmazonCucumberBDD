package amazon.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class JavascriptActions {

	public static void ClickUsingJS(WebElement element) {

		JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;
		jse.executeScript("arguments[0].click()", element);
	}

}
