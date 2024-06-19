package record.and.trace;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class VideoRecord {

	public static void main(String[] args) {
			Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			BrowserContext context = browser
					.newContext(new Browser.NewContextOptions()
					.setRecordVideoDir(Paths.get("./src/test/resources/Output/")));
					// record video in particular screen size
					//.setRecordVideoDir(Paths.get("./src/test/resources/Output/")).setRecordVideoSize(640, 480));
		
			
			Page page = context.newPage();
			page.navigate("https://academy.naveenautomationlabs.com/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
			page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Bredlin");
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("Bangalore");
			page.frameLocator("#microfe-popup-login")
					.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("India: +")).click();
			page.frameLocator("#microfe-popup-login").getByText("Hong Kong").click();
			page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
			page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();
			
			context.close();
			page.close();
			playwright.close();
	}
}
