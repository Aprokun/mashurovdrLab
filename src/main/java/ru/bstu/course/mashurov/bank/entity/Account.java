package ru.bstu.course.mashurov.bank.entity;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
public class Account {

    protected UUID id;

    private static int currentId;
    protected int id;
    protected Client client;
    protected Bank bank;

    private void initId() {
        id = currentId++;
    }

    public Account() {

        initId();
        initWithDefaults();
    }

    public Account(Client client, Bank bank) {

        initId();
        initWithDefaults();

        this.client = client;
        this.bank = bank;
    }

    public Account(int id, Client client, Bank bank) {

        this.id = id;
        this.client = client;
        this.bank = bank;
    }

    public Account(Account account) {

        this.id = account.id;
        this.client = new Client(account.client);
        this.bank = new Bank(account.bank);
    }

    @Override
    public String toString() {

        return """
            Account:{
                id='%s',
                client='%s',
                bank='%s'
            }
            """.formatted(getId(), getClient(), getBank().getName());
    }

}
