package amazon.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.util.Driver;
import amazon.util.DynamicWait;
import amazon.util.JavascriptActions;

public class HomePage {

	@FindBy(xpath = "//span[@class= 'nav-sprite nav-logo-base']")
	WebElement AmazonLogo;
	@FindBy(id = "twotabsearchtextbox")
	WebElement AmazonSearchTxt;
	@FindBy(xpath = "//input[@type = 'submit' and @class='nav-input']")
	WebElement SearchBtn;
	
	public HomePage() {
		PageFactory.initElements(Driver.driver, this);
	}
	
	public Boolean VerifyAmazonLogo() {
		return AmazonLogo.isDisplayed();
	}
	
	public void SearchItems(String item) {
		DynamicWait.toBeclickable(AmazonSearchTxt);
		AmazonSearchTxt.clear();
		AmazonSearchTxt.sendKeys(item);
		DynamicWait.toBeclickable(SearchBtn);
		JavascriptActions.ClickUsingJS(SearchBtn);
	}
}


