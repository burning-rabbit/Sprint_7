package org.example.models;

import org.example.utils.Utils;

public class CourierCreds {
        private String login;
        private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CourierCreds(String login, String password) {
            this.login = login;
            this.password = password;
        }

    public static CourierCreds credsFromCourier(Courier courier) {
            return new CourierCreds(courier.getLogin(), courier.getPassword());
        }

        public static CourierCreds credsWithoutLogin(Courier courier) {
            return new CourierCreds (null, courier.getPassword());
        }

        public static CourierCreds credsWithoutPassword(Courier courier) {
            return new CourierCreds(courier.getLogin(), null);
        }

        public static CourierCreds credsWithWrongLogin(Courier courier) {
            return new CourierCreds(Utils.randomString(10), courier.getPassword());
        }

        public static CourierCreds credsWithWrongPassword(Courier courier) {
            return new CourierCreds(courier.getLogin(), Utils.randomString(10));
        }
}
