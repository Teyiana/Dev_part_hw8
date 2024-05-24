package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientService {

    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private PreparedStatement selectSt;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO client (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        readSt = connection.prepareStatement("SELECT id, name FROM client WHERE id = ?");
        updateSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
        selectSt = connection.prepareStatement("SELECT * FROM client");

    }


    public long create(String name) throws SQLException {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Name must be between 2 and 1000 characters long.");
        }
        createSt.setString(1, name);
        createSt.execute();
        ResultSet resultSet = createSt.getGeneratedKeys();
        if (resultSet.next()) {
            return resultSet.getLong(1);
        }
        return -1;
    }


    public Client getById(long id) throws SQLException {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be between 1 and 9,223,372,036,854,775,807 digital input.");
        }
        readSt.setLong(1, id);
        ResultSet resultSet = readSt.executeQuery();

        if (!resultSet.next()) {
            return null;
        }
        id = resultSet.getLong("id");
        String name = resultSet.getString("name");

        Client result = new Client();
        result.setId(id);
        result.setName(name);
        return result;
    }

    public void setName(long id, String name) throws SQLException {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Name must be between 2 and 1000 characters long.");
        }
        updateSt.setLong(2, id);
        updateSt.setString(1, name);
        updateSt.execute();
    }

    public void deleteById(long id) throws SQLException {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be between 1 and 9,223,372,036,854,775,807 digital input.");
        }
        deleteSt.setLong(1, id);
        deleteSt.execute();
    }

    public List<Client> listAll() throws SQLException {
        ResultSet resultSet = selectSt.executeQuery();
        List<Client> result = new ArrayList<>();

        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            result.add(client);
        }
        return result;

    }
}
