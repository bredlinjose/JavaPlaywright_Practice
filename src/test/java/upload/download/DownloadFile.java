package upload.download;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(() ->{ // download in temporary file path
			page.click("a:text('chromedriver_win32.zip')");
		});
		//download.cancel();
		System.out.println("Failure Message: "+ download.failure());
		
		System.out.println("Download URL: "+download.url());
		System.out.println("Temp Download Path: "+download.path().toString());
		
		// download in particular directory
		download.saveAs(Paths.get("./src/test/resources/Output/chrome-driver.zip"));
		System.out.println("File name: "+ download.suggestedFilename()); // chromedriver_win32.zip
		
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}

}
