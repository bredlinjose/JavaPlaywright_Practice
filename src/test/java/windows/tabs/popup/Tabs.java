package windows.tabs.popup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tabs {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		Page newPage = page.waitForPopup(() -> {
			page.locator("//div[@class='orangehrm-login-footer-sm']/a[contains(@href,'twitter')]").click();
		});
		newPage.waitForLoadState();
		
		System.out.println("New Page URL: "+ newPage.url());
		newPage.close();
		
		System.out.println("Parent Page URL: "+ page.url());
		page.close();
		
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
