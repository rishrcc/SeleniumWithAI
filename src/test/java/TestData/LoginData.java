package TestData;

public class LoginData {

    public static String weakAuthUrl = "******";

    public enum Customer_3x {

        USER_IAD("****"),
        USER_PASSWORD("***");

        private final String value;

        Customer_3x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_4x {

        USER_IAD("*****"),
        USER_PASSWORD("*****");

        private final String value;

        Customer_4x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_pre_contentieux {

        USER_IAD("*****"),
        USER_PASSWORD("*****");

        private final String value;

        Customer_pre_contentieux(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_RCP {

        USER_IAD("*****"),
        USER_PASSWORD("*****");

        private final String value;

        Customer_RCP(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
