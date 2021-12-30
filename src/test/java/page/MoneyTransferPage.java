package page;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    public DashboardPage makeTransfer(String amount, String cardNumber) {
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=from] input").setValue(cardNumber);
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }
}
