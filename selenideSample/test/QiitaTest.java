package selenideSample.test;

import static com.codeborne.selenide.Selenide.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.openqa.selenium.Dimension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;

import selenideSample.pageObject.QiitaTopPage;

public class QiitaTest {

	/**
	 * テストの前に1度だけ実施
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("at beforeClass");

		// Chrome Driverのパスを指定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		System.setProperty("chromeoptions.args", "--incognito");
		System.setProperty("chromeoptions.prefs", "intl.allowed_languages=jp");

		// Chromeを指定
		Configuration.browser = WebDriverRunner.CHROME;

		// ヘッドレスモード
		Configuration.headless = true;

		// ブラウザサイズ
		//		Configuration.browserSize = "1366x768";
		Configuration.startMaximized = true;

		// HTMLは保存しない
		Configuration.savePageSource = false;

		// 文字にJavaScriptを使用する(高速化)
		Configuration.fastSetValue = true;

	}

	/**
	 * 各テストの前に実施
	 */
	@Before
	public void before() {
		System.out.println("at before");
	}

	@Rule
	public TestRule report = new TextReport();

	@Rule
	public TestName testName = new TestName();

	@Test
	public void topPage() {
		open(QiitaTopPage.URL, QiitaTopPage.class);
	}

	@Test
	public void goSearchPage() {
		open(QiitaTopPage.URL, QiitaTopPage.class)
				.serch("selenide");
	}

	/**
	 * 各テストの後に実施
	 */
	@After
	public void after() {
		System.out.println("at after");

		// scrollを取得
		long pageWidth = Selenide.executeJavaScript("return document.body.scrollWidth");
		long pageHight = Selenide.executeJavaScript("return document.body.scrollHeight");

		// ウィンドウをリサイズ
		WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension((int) pageWidth, (int) pageHight));

		// スクリーンショットを取得
		Selenide.screenshot(this.getClass().getName() + testName.getMethodName());

		// 取得後，元に戻す
		WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1366, 768));
	}

	/**
	 * テストの後に1度だけ実施
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("at afterClass");
		close();
	}
}
