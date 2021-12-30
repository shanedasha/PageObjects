package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenTwoCard() {
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.ValidLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.ValidCode(verifyInfo);
        var amount = 1000;
        var expectedBalanceFirstCArd = dashboardPage.getCardBalance(DataHelper.getFirstCard().getId()) + amount;
        var expectedBalanceSecondArd = dashboardPage.getCardBalance(DataHelper.getSecondCard().getId()) - amount;
        var moneyTransferPage = dashboardPage.topUpCard(DataHelper.getFirstCard().getId());
        moneyTransferPage.makeTransfer(String.valueOf(amount), DataHelper.getSecondCard().getNumber());
        assertEquals(expectedBalanceFirstCArd, dashboardPage.getCardBalance(DataHelper.getFirstCard().getId()));
        assertEquals(expectedBalanceSecondArd, dashboardPage.getCardBalance(DataHelper.getSecondCard().getId()));
    }
}
