package browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	static String browserName = "chrome";
	static Browser browser;

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		
		switch (browserName.toLowerCase().trim()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;

		case "msedge":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(false));
			break;

		default:
			System.out.println("Please enter the valid Browser name");
			break;
		}
		System.out.println("<< Launched "+ browserName +" Browser >>");
		
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");

		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
