package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactSelector {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.netflix.com/in/");
		
		Locator locator = page.locator("_react=input[name='email']").first();
		locator.click();
		locator.fill("bredlinjose@gmail.com");
		
		page.locator("_react=select[data-uia='language-picker']").click();
		
		Locator footers = page.locator("_react=a[data-uia='footer-link']");
		footers.allTextContents().forEach(txt -> System.out.println(txt));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
