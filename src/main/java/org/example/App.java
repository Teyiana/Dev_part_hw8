package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        ClientService clientService = new ClientService(Database.getDbConnection());
        clientService.create("Robert");
        clientService.getById(1);
        clientService.setName(1, " Robert");
        clientService.deleteById(1);
        clientService.listAll();

    }
}
