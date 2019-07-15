package selenideSample.pageObject;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;

public class QiitaSerchResultPage {

	protected String URL = "https://qiita.com/search?q=selenide";
	protected ElementsCollection resultItems = $$(".searchResult");

	public QiitaSerchResultPage() {
		resultItems.shouldHaveSize(10);
	}

	public QiitaContentsPage openItem(int index) {
		resultItems.get(index)
				.click();

		return new QiitaContentsPage();
	}

}
