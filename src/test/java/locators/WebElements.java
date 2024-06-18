package locators;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.record.CountryRecord;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");

//		Locator contactSales = page.locator("text = Contact Sales");
//		int count= contactSales.count();
//		System.out.println("Contact Sales count: "+count);
//		contactSales.last().click();
//		page.goBack();
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		int countryCount = countryOptions.count();
		System.out.println("Country Count: "+countryCount);
//		for (int i = 0; i < countryCount; i++) {
//			System.out.println(countryOptions.nth(i).textContent());
//		}
		
		List<String> allCountry = countryOptions.allTextContents();
//		for (String string : allCountry) {
//			System.out.print(string + " ");
//		}
		
		allCountry.forEach(s -> System.out.print(s));
		
		playwright.close();
		
	}

}
