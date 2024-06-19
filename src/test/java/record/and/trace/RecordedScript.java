package record.and.trace;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RecordedScript {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.google.com/");
			page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
			page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("Bredlin");
			// page.pause(); // from this line it will launch the Playwright Inspector
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google Search")).first().click();
			assertThat(page.getByText("Did you mean:")).isVisible();
			assertThat(page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")))
					.hasValue("Bredlin");
			assertThat(page.locator("#rso")).containsText("Bredlin Jose");

			page.close();
			context.close();
			browser.close();
			playwright.close();

		}

	}

}
