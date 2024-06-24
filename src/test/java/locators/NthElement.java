package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElement {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.amazon.in/");
		
		Locator first= page.locator("div.navFooterVerticalRow.navAccessibility li a >> nth=0"); //first
		System.out.println("First Element: "+ first.textContent());
		Locator last= page.locator("div.navFooterVerticalRow.navAccessibility li a >> nth=-1"); //last
		
		System.out.println("Last Element: "+ last.textContent());
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
