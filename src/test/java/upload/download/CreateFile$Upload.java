package upload.download;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class CreateFile$Upload {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
//		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
//		//create file in run time & upload
//		page.setInputFiles("input#filesToUpload", 
//				new FilePayload("bredlin.txt", "text/plain", "Hi this is Bredlin".getBytes(StandardCharsets.UTF_8)));		
		
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		//create file in run time & upload
		page.setInputFiles("input[name='upfile']", 
				new FilePayload("bredlin.txt", "text/plain", "Hi this is Bredlin".getBytes(StandardCharsets.UTF_8)));		
		page.click("input[value='Press']");
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}

}
