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
        String text;
        text = String.valueOf(cards.filterBy(Condition.text(id)));
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DashboardPage TopUpFirstCard(DataHelper.SecondCard secondCard) {
        $("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0]").shouldBe(Condition.visible);
        $("[data-test-id=action-deposit]").click();
        $("[data-test-id=amount]").setValue("120");
        $("[data-test-id=from]").setValue(DataHelper.getSecondCard().getNumber());
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }

    public DashboardPage TopUpSecondCard() {
        $("[data-test-id=0f3f5c2a-249e-4c3d-8287-09f7a039391d]").shouldBe(Condition.visible);
        $("[data-test-id=action-deposit]").click();
        $("[data-test-id=amount]").setValue("120");
        $("[data-test-id=from]").setValue(DataHelper.getFirstCard().getNumber());
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }
}
