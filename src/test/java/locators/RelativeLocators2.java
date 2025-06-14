package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators2 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		page.locator("input:below(label:text('Username'))").first().fill("Admin");
		page.locator("input:below(label:text('Password'))").first().fill("admin123");
		page.locator("button[type='submit']").click();

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
