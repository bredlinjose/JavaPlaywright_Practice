package locators;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class VisibleElement {
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://www.amazon.in/");
		page.waitForLoadState(LoadState.LOAD);

		System.out.println("waiting done");	
		page.pause();
			
		//List<String> links = page.locator("a:visible").allInnerTexts();
		List<String> links = page.locator("a >> visible=true").allInnerTexts();
		links.forEach(lnk -> System.out.println(lnk));
		
//		List<String> strings = page.locator("a:visible").allTextContents();
//		strings.forEach(s -> System.out.println(s));
		
		int count = page.locator("xpath =//img >> visible=true").count();
		System.out.println("No. of img: "+ count);
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}
	
	
}
