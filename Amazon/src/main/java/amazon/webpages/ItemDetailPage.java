package amazon.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.util.ConvertFunctions;
import amazon.util.Driver;
import amazon.util.DynamicWait;
import amazon.util.JavascriptActions;

public class ItemDetailPage {
	public static double  Totalvalue ;
	@FindBy(id="add-to-cart-button")
	WebElement AddtoCartBtn;
	
	@FindBy(xpath = "//div[@id = 'hlb-subcart']//span[@class = 'a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement TotalPriceOnAmazon;
	
	@FindBy(id = "hlb-ptc-btn-native")
	WebElement CheckoutBtn;
	
	@FindBy(id = "continue")
	WebElement ContinueBtn;
	
	@FindBy(id = "productTitle")
	WebElement ProductTitle;

	
	public ItemDetailPage() {
		PageFactory.initElements(Driver.driver, this);
	}
	
	public void AddtoCart(Double value, String itemname) {
		DynamicWait.toBeclickable(AddtoCartBtn);
		
		System.out.println("Available Cheapest price of item " + itemname + " is : "  + GetProductTitle() + " " + value);
		JavascriptActions.ClickUsingJS(AddtoCartBtn);

		Totalvalue = Totalvalue + value; //adding amounts to get the total
		Totalvalue = ConvertFunctions.RoundAmounts(Totalvalue); //rounding to two decimals

	}
	
	public double PriceOnAmazon() {
		String str = TotalPriceOnAmazon.getText();
		str =  ConvertFunctions.ExtractValue(str);
		str = ConvertFunctions.RemoveCommafromCurrencyFormat(str);
		return ConvertFunctions.ConvertStringtoDouble(str);
	}
	public void Checkout() {
		DynamicWait.toBeclickable(CheckoutBtn);
		JavascriptActions.ClickUsingJS(CheckoutBtn);
	}
	public Boolean SignInCheck() {
		return ContinueBtn.isDisplayed();
		
	}
	
	public String  GetProductTitle() {
		return ProductTitle.getText().trim();
	}
}
