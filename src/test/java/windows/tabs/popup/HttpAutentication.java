package windows.tabs.popup;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HttpAutentication {
	
	@Test
	public void handle_authentication_popup() {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
		Page page = context.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		String text = page.locator("div.example").textContent();
		System.out.println(text);
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
		
	}
}
