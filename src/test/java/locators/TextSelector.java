package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//page.locator("text=Login").click();
		
		//page.locator("button:has-text('Login')").click();
		
		page.locator("div.orangehrm-login-action button:has-text('Login')").click(); //tagName.classValue (space for the child)tagName:has-text('text')
		
		String string = page.locator("text=Forgot your password?").textContent();
		System.out.println(string);
		string = page.locator("'Forgot your password?'").textContent(); // both are same
		System.out.println(string);
		
		
		page.close();
		context.close();
		browser.close();
		playwright.close();


	}

}
