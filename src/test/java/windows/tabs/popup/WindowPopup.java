package windows.tabs.popup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopup {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bx1 = browser.newContext();
		BrowserContext bx2 = browser.newContext();
		
		Page page1 = bx1.newPage();
		Page page2 = bx2.newPage();
		
		page1.navigate("https://www.google.com/");
		page2.navigate("https://www.amazon.com/");
		
		
		browser.close();
		playwright.close();

	}

}
