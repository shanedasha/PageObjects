package page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import data.DataHelper;
import lombok.val;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item");
    final String balanceStart = "баланс: ";
    final String balanceFinish = " р.";

    public DashboardPage() {
    }

    public int getCardBalance(String id) {
        val text = $("[data-test-id='" + id + "'").getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public MoneyTransferPage topUpCard(String id) {
        $("[data-test-id='" + id + "'").find("button").click();
        return new MoneyTransferPage();
    }
}
