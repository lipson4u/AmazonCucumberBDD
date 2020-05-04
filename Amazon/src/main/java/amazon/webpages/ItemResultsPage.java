package amazon.webpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.util.Driver;
import amazon.util.DynamicWait;
import amazon.util.JavascriptActions;

public class ItemResultsPage {
	@FindBy(id="a-autoid-0-announce")
	WebElement Sortdd;
	
	@FindBy(id="s-result-sort-select_1")
	WebElement SortLowestdd;
	
	@FindBy(xpath = "//div[@class= 's-result-list s-search-results sg-row']/div[@data-index='0']")
	WebElement FirstLowestItem;
	
	String allitemslist = "//span[@class = 'a-price-whole']";
	String Itemprice = "//span[@class = 'a-price-whole' and contains(text(),'";
	ItemDetailPage itemdetailpage;
	public ItemResultsPage() {
		PageFactory.initElements(Driver.driver, this);
		itemdetailpage= new ItemDetailPage();
	}
	
	public void ClickSortitemstoLowest() {
		DynamicWait.toBeclickable(Sortdd);
		JavascriptActions.ClickUsingJS(Sortdd);
		DynamicWait.toBeclickable(SortLowestdd);
		JavascriptActions.ClickUsingJS(SortLowestdd);
	}
	public List<Double> SortLowestPriceItems() {
		String itemvalue ;
		double finalcurrencyvalue;
		List<Double> sortedcurrencyvalues = new ArrayList<Double>();
		List <WebElement> elements = Driver.driver.findElements(By.xpath(allitemslist));
		System.out.println("No of items found : " + elements.size());

		for(int i=0;i < elements.size();  i++) {
			itemvalue = elements.get(i).getText().replace(',', '.');
			finalcurrencyvalue = Double.parseDouble(itemvalue);
			sortedcurrencyvalues.add(finalcurrencyvalue);
		}
		Collections.sort(sortedcurrencyvalues);
		System.out.println("Sorted values are : " +sortedcurrencyvalues);
		return sortedcurrencyvalues;
	}
		public void AddItemToBasket(List<Double> sortedcurrencyvalues,String itemname) throws InterruptedException {
			String item;
			WebElement selecteditem;
			for(int i=0; i < sortedcurrencyvalues.size();i++) {
				item = Double.toString(sortedcurrencyvalues.get(i)).toString().replace(".", ",");
				//Thread.sleep(5000);
				selecteditem = Driver.driver.findElement(By.xpath(Itemprice+ item +"')]"));
				DynamicWait.toBeclickable(selecteditem);
				JavascriptActions.ClickUsingJS(selecteditem);
				try {
					itemdetailpage.AddtoCart(sortedcurrencyvalues.get(i),itemname);
					break;
				} catch (Exception e) {
					Driver.driver.navigate().back();
				}
			}
		}
	
}
