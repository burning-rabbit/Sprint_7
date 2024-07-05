package org.example.courier;

import org.example.models.Courier;

import static org.example.utils.Utils.randomString;

public class CourierGenerator {
    public static Courier randomCourier() {
        return new Courier()
                .withLogin(randomString(10))
                .withPassword(randomString(10))
                .withFirstName(randomString(10));
    }

    public static Courier withOutLoginCourier() {
        return new Courier()
                .withPassword(randomString(10))
                .withFirstName(randomString(10));
    }

    public static Courier withOutPasswordCourier() {
        return new Courier()
                .withLogin(randomString(10))
                .withFirstName(randomString(10));
    }

    public static Courier withOutFirstNameCourier() {
        return new Courier()
                .withLogin(randomString(10))
                .withPassword(randomString(10));
    }

}
