package selenideSample.pageObject;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class QiitaTopPage extends QiitaBasePage {

	public static String URL = "https://qiita.com/";

	protected SelenideElement helloHackers = $(withText("Hello hackers !"));

	public QiitaTopPage() {
		System.out.println("constructer qiita top page");
		this.helloHackers.should(exist);
	}

	public QiitaSerchResultPage serch(String serchWord) {
		searchInput.sendKeys(serchWord);
		searchInput.pressEnter();
		return new QiitaSerchResultPage();
	}

}