package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    public DashboardPage() {
        $("[data-test-id=dashboard]").shouldBe(Condition.visible);
        $$(".list__item");
        final String balanceStart = "баланс: ";
        final String balanceFinish = " р.";

        public int getFirstCardBalance() {
            val text = DataHelper.getFirstCard().text();
            return extractBalance(text);
        }
        public int getSecondCardBalance() {
            val text = DataHelper.getSecondCard().text();
            return extractBalance(text);
        }

        private int extractBalance(String text){
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }
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
