package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
 * any one matches it will perform action
 */
public class CommaSelectors {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		// validate the important elements from the page
		Locator elements= page.locator("a:has-text('Login'), a:has-text('EXPLORE COURSES'), h1:has-text('ABOUT us')");
		int count = elements.count();
		
		if (count==3)
			System.out.println("PASS");
		else
			System.err.println("FAIL");
		
//		Locator btn= page.locator("a:has-text('Login'), a:has-text('Signin'), a:has-text('Log In')");		
//		btn.click();
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
