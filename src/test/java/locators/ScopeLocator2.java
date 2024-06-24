package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocator2 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://primeng.org/");
		
		Locator row = page.locator("table#pn_id_1-table tbody tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText("Art Venere")).locator("div.p-checkbox-box").click();
		
		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
