package amazon.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import amazon.util.Driver;
import amazon.webpages.HomePage;
import amazon.webpages.ItemDetailPage;
import amazon.webpages.ItemResultsPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class checkoutstepdefinition {
	HomePage homepage;
	WebDriver driver;
	ItemResultsPage itemresultspage;
	ItemDetailPage itemdetailpage;
	@Before
	public void Setup() {
		Driver.initialize();
		homepage = new HomePage();
		itemresultspage = new ItemResultsPage();
		itemdetailpage = new ItemDetailPage();
	}
	
	@Then("^user should see the amazon logo$")
	public void i_should_see_the_amazon_logo()  {
	   Boolean logo = homepage.VerifyAmazonLogo();
	   Assert.assertTrue(logo);
	}

	@Then("^User searches and adds the available cheapest price to the basket$")
	public void user_searches_for_Cheapest_Snickers_and_Skittles(DataTable items) throws InterruptedException  {
		
		for (Map<String, String> data : items.asMaps(String.class, String.class)) {
		System.out.println("Item to Search Next : " + data.get("Item"));
		homepage.SearchItems(data.get("Item"));
		Thread.sleep(3000);
		itemresultspage.ClickSortitemstoLowest(); // clicking the drop down and selecting the value from lowest to high
		Thread.sleep(3000);
		List<Double> sortedprices = itemresultspage.SortLowestPriceItems();  //sorting the values in the first page
		//adding the available smallest price item to the basket only if add to basket button is available
		itemresultspage.AddItemToBasket(sortedprices,data.get("Item")); 
	}
	}
	

	@Then("^User verifies the basket is calculated correctly$")
	public void user_verifies_the_basket_is_calculated_correctly() {
	    System.out.println("Total value : " + ItemDetailPage.Totalvalue);
	    Assert.assertEquals((ItemDetailPage.Totalvalue), itemdetailpage.PriceOnAmazon(),0);
	}

	@When("^User try to checkout$")
	public void user_try_to_checkout() throws Throwable {
		itemdetailpage.Checkout();
	}

	@Then("^User is getting redirected to SignIn Page$")
	public void user_is_getting_redirected_to_SignIn_Page() {
	 Boolean login = itemdetailpage.SignInCheck();
	   Assert.assertTrue(login);

	}

	@After
	public void teardown() {
		Driver.quit();
	}

}
