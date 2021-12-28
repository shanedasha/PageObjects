package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    @Value
    public static class FirsCard {
        private String number;
        private String balance;
        private String id;
    }

    public static FirsCard getFirstCard() {
        return new FirsCard("5559 0000 0000 0001", "10 000 RUB","92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    @Value
    public static class SecondCard {
        private String number;
        private String balance;
        private String id;
    }

    public static SecondCard getSecondCard() {
        return new SecondCard("5559 0000 0000 0002", "10 000 RUB","0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }
}
