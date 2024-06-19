package browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleBrowser {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context1 = browser.newContext();
		Page page1 = context1.newPage();
		page1.navigate("https://academy.naveenautomationlabs.com/");

		BrowserContext context2 = browser.newContext();
		Page page2 = context2.newPage();
		page2.navigate("https://trace.playwright.dev/");

		BrowserContext context3 = browser.newContext();
		Page page3 = context3.newPage();
		page3.navigate("https://www.google.com/");

		page3.navigate("https://www.youtube.com/");

		playwright.close();

	}

}
