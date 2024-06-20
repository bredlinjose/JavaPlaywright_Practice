package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle2 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Bredlin");

		
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}

}
