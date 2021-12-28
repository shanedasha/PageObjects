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
        dashboardPage.getCardBalance("92df3f1c-a033-48e6-8390-206f6b1f56c0");
        dashboardPage.getCardBalance("0f3f5c2a-249e-4c3d-8287-09f7a039391d");
        dashboardPage.TopUpFirstCard(DataHelper.getSecondCard());
        assertEquals("9880",dashboardPage.getCardBalance("92df3f1c-a033-48e6-8390-206f6b1f56c0"));
        assertEquals("10120",dashboardPage.getCardBalance("0f3f5c2a-249e-4c3d-8287-09f7a039391d"));
    }
}
