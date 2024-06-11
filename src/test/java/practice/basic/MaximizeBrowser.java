package practice.basic;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {
	
	@Test
	public void maximizeBrowser() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println("Width: "+ width +" Height: "+ height);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = context.newPage();
		page.navigate("https://www.google.com/");
		System.out.println(page.title());

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}
}
