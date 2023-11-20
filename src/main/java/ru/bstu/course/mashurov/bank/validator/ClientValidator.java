package ru.bstu.course.mashurov.bank.validator;

import ru.bstu.course.mashurov.bank.entity.Client;

public class ClientValidator {
    public static boolean validateCreate(Client client) {
        if (client == null) {
            return true;
        }

        if (client.getBank() == null) {
            System.err.println("Error: Client - must have bank");
            return true;
        }
        return false;
    }
}
