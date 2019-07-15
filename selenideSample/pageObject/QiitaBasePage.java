package selenideSample.pageObject;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class QiitaBasePage {

	protected SelenideElement banner = $("div.st-Header_start");
	protected SelenideElement searchInput = $(".st-Header_searchInput");

	public QiitaBasePage() {
		System.out.println("base page constructed");
		banner.should(exist);
		searchInput.should(exist);
	}

}
