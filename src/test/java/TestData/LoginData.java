package TestData;

public class LoginData {

    //public static String weakAuthUrl = "https://qlf-espaceclient.oney.fr/login?dl=true";
    //public static String weakAuthUrl = "https://oney-website-integration.onbadi.com/login?dl=true";
    //public static String weakAuthUrl = "https://oney-espace-client-integration.onbadi.com/login?dl=true";

    //public static String weakAuthUrl = "https://oneyfr-stg-beta.azurewebsites.net/login?dl=true";
    public static String weakAuthUrl = "https://qlf-espaceclient.oney.fr/login?dl=true";

    public enum Customer_3x {

        USER_IAD("306463019"),
        USER_PASSWORD("12345");

        private final String value;

        Customer_3x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_4x {

        USER_IAD("qetukkczcfnid.txmsnsqgvbc.10x12x.ok@oney.fr"),
        USER_PASSWORD("Passw0rd");

        private final String value;

        Customer_4x(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_pre_contentieux {

        USER_IAD("regimeqbaviere@oney.fr"),
        USER_PASSWORD("Passw0rd");

        private final String value;

        Customer_pre_contentieux(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Customer_RCP {

        USER_IAD("302712245@oney.fr"),
        USER_PASSWORD("Passw0rd");

        private final String value;

        Customer_RCP(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
