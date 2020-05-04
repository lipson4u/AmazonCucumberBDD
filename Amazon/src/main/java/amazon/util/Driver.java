package amazon.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {
public static WebDriver driver=null;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;	
	//Private constructor to limit initialization, Initializes browser based on inputs from properties file
	private Driver()
	{
		String browser=ReadPropertyFile.get("Browser");
		String imageDisable=ReadPropertyFile.get("DisableImage");
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			try{
				System.setProperty("webdriver.chrome.silentOutput","true");

				WebDriverManager.chromedriver().setup();
				//	System.setProperty("webdriver.chrome.driver",OsPath.getPath(browser));

				ChromeOptions options=new ChromeOptions();
				options.addArguments("disable-infobars");

				//options.addArguments("--incognito");
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(options);
				}
				
				DesiredCapabilities capabilites=DesiredCapabilities.chrome();
				capabilites.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(options);								
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
		{
			try
			{
				System.setProperty("webdriver.firefoxdriver.silentOutput","true");

				WebDriverManager.firefoxdriver().setup();

			//	System.setProperty("webdriver.gecko.driver",OsPath.getPath(browser));
				FirefoxOptions FFoptions=new FirefoxOptions();

				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(FFoptions);
				}
				driver=new FirefoxDriver(FFoptions)	;			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//EventHandlerInit();
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().deleteAllCookies();
	}
	
	//Initializes browser instance
	public static void initialize()
	{
		new Driver();
	}
	//quits browser
	public static void quit()
	{
		driver.quit();
	}
	//initializes WebDriver EventListner
	public void EventHandlerInit()
	{
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	}
	
}
