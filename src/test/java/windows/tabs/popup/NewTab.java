package windows.tabs.popup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NewTab {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Page newPage = page.waitForPopup(() -> {
			page.click("a[target = '_blank']"); // this will open a new tab
		});
		newPage.waitForLoadState();
		
		newPage.navigate("https://www.google.com/");
		System.out.println("New Page Title: "+ newPage.title());
		newPage.close();
		
		System.out.println("Parent Page Title: "+ page.title());

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
