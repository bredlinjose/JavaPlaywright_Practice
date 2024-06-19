package auto.login;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("http://www.automationpractice.pl/");
		
		page.click("a:text('Sign in')");
		page.fill("#email", "bredlinjose@gmail.com");
		page.fill("#passwd", "Password@123");
		page.click("#SubmitLogin");
		
		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("./src/test/resources/Output/loginInfo.json")));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
