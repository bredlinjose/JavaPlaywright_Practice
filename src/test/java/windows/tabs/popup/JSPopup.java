package windows.tabs.popup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
 * By default JS Popup is handled automatically when clicking.
 * Incase if you want to handle with particular data we will go for listeners
 */
public class JSPopup {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.onDialog(dialog -> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("This is the message.");
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.click("//button[text()='Click for JS Alert']");
		String message = page.textContent("#result");
		System.out.println(message);
		
		
		page.click("//button[text()='Click for JS Confirm']");
		message = page.textContent("#result");
		System.out.println(message);
		
		page.click("//button[text()='Click for JS Prompt']");
		message = page.textContent("#result");
		System.out.println(message);
		
		page.close();
		browser.close();
		playwright.close();

	}

}
