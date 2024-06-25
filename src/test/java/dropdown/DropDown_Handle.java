package dropdown;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

/*
 * drop down must be in select tag
 */
public class DropDown_Handle {

	@Test
	public void handle_dropdown() throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://letcode.in/dropdowns");
		
		Locator dropdown = page.locator("#fruits");
		
		// select by value 1
		page.selectOption("#fruits", "3");
		String text = page.locator("p.subtitle").textContent();
		System.out.println(text);
		// select by value 2
		dropdown.selectOption("2");
		text = page.locator("p.subtitle").textContent();
		System.out.println(text);
				
		// select by visible text
		dropdown.selectOption(new SelectOption().setLabel("Banana"));
		text = page.locator("p.subtitle").textContent();
		System.out.println(text);
				
		// select by index
		//dropdown.selectOption(new SelectOption().setIndex(1));
		dropdown.selectOption(new SelectOption().setIndex(1), new SelectOptionOptions().setForce(false));
		text = page.locator("p.subtitle").textContent();
		System.out.println(text);
		
		//select multiple options (we can't use label or index, we can go only with value)
		Locator heros = page.locator("#superheros");
		heros.selectOption(new String[] {"am","ta","bw","ca"});
		
		// select the last option
		Locator lang = page.locator("#lang");
		Locator langOpt = page.locator("select#lang option");
		int count = langOpt.count();
		lang.selectOption(new SelectOption().setIndex(count-1));
		// print all options
		langOpt.allInnerTexts().forEach(e -> System.out.println(e));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}
}
