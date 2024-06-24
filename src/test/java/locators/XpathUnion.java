package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
 * any one matches, it will perform action
 */
public class XpathUnion {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		// | is valid, & is invalid
		Locator btn= page.locator("//a[text()='Login'] | //a[text()='Signin']"); 	
		btn.click();
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
