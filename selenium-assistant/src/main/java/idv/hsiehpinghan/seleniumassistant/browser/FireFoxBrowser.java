package idv.hsiehpinghan.seleniumassistant.browser;

import idv.hsiehpinghan.seleniumassistant.webdriver.FirefoxDriverExtension;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FireFoxBrowser extends BrowserBase {
	@Autowired
	private FirefoxDriverExtension webDriver;

	@Override
	public File download(String filePath) {
		InputStream is = webDriver.getPageSourceAsInputStream();
		File f = new File(filePath);
		try {
			FileUtils.copyInputStreamToFile(is, f);
		} catch (IOException e) {
			return null;
		}
		return f;
	}

	@Override
	protected WebDriver getWebDriver() {
		return webDriver;
	}
}
