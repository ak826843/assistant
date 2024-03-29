package idv.hsiehpinghan.seleniumassistant.utility;

import idv.hsiehpinghan.seleniumassistant.browser.BrowserBase;
import idv.hsiehpinghan.seleniumassistant.browser.HtmlUnitBrowser;
import idv.hsiehpinghan.seleniumassistant.webelement.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AjaxWaitUtilityTest {
	private static final String URL_BASE = "http://127.0.0.1:8080/";
	private BrowserBase browser;

	@BeforeClass
	public void beforeClass() {
		browser = new HtmlUnitBrowser();
	}

	@Test
	public void waitUntilOptionsDifferent() {
		browser.browse(URL_BASE + "html/selenium_index.html");
		Select s = browser.getSelect(By.cssSelector("#selectId"));
		Select s2 = browser.getSelect(By.cssSelector("#selectId_2"));
		Assert.assertTrue(AjaxWaitUtility.waitUntilOptionsDifferent(s2,
				s.getOptions()));
	}

	@Test(expectedExceptions = { TimeoutException.class })
	public void waitUntilOptionsDifferent2() {
		browser.browse(URL_BASE + "html/selenium_index.html");
		Select s = browser.getSelect(By.cssSelector("#selectId"));
		Select s3 = browser.getSelect(By.cssSelector("#selectId_3"));
		Assert.assertTrue(AjaxWaitUtility.waitUntilOptionsDifferent(s3,
				s.getOptions()));
	}

}
