package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenTwoCard() {
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.ValidLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.ValidCode(verifyInfo);
        var secondCard = DataHelper.getSecondCard();
        dashboardPage.TopUpFirstCard(secondCard);
        dashboardPage.getFirstCardBalance();
        dashboardPage.getSecondCardBalance();
    }
}
