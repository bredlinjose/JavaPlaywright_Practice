package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/*
 * has() will check the parent which contain the particular child
 * and it will highlight the parent element
 * If we have multiple element in the same name then we can use this
 */
public class HasElement1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		
		Locator countryLoc= page.locator("select#Form_getForm_Country:has(option[value='India'])");
		countryLoc.allInnerTexts().forEach(loc -> System.out.println(loc));
		
		//countryLoc.click();
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
