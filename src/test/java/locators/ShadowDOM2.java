package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM2 {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		//page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		
		// Page -- DOM --> Iframe --> Shadow DOM --> elements
		
//		Page newPage = page.waitForPopup(() ->{
//			page.locator("text=Click to practice shadow dom inside iframe scenario").click();
//		});
//		newPage.waitForLoadState();
//		Thread.sleep(4000);
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Tea");

		
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}

}
