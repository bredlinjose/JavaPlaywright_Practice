package frames.shadowdom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		
		// Page -- DOM --> Shadow DOM --> elements
	
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Bredlin");
		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(text);
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}

}
