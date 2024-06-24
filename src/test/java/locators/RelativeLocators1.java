package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators1 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://selectorshub.com/xpath-practice-page/");

		// left-of()
		page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click(); // checkbox is left of text Joe.Root

		// right-of()
		String text = page.locator("td:right-of(:text('Joe.Root'))").first().textContent(); // td is right of text Joe.Root
		System.out.println(text);

		// above()
		text = page.locator("a:above(:text('Joe.Root'))").first().textContent(); // above the text Joe.Root
		System.out.println(text);

		// below()
		text = page.locator("a:below(:text('Joe.Root'))").first().textContent(); // below the text Joe.Root
		System.out.println(text);
		
		// near()
		page.locator("td.left:near(:text('Joe.Root'))").allInnerTexts().forEach(txt -> System.out.println(txt));
		
		// near pixel
		page.locator("td.left:near(:text('Joe.Root'),400)").allInnerTexts().forEach(txt -> System.out.println(txt));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
