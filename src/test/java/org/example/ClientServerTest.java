package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServerTest {

    @Mock
    private PreparedStatement createSt;
    @Mock
    private PreparedStatement readSt;
    @Mock
    private PreparedStatement updateSt;

    @Mock
    private PreparedStatement selectSt;
    @Mock
    private PreparedStatement deleteSt;

    @InjectMocks
    private ClientService clientService = spy(new ClientService(Database.getDbConnection()));

    public ClientServerTest() throws SQLException {
    }

    @Test
    public void test_create_success() throws SQLException {
        String name = "Robert";
        long expected = 78;
        ResultSet resultSet = mock(ResultSet.class);
        when(createSt.getGeneratedKeys()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getLong(1)).thenReturn(expected);

        long result = clientService.create("Robert");
        verify(createSt).setString(1, name);
        verify(createSt).execute();
        assertEquals(expected, result);
    }

    @Test
    public void test_create_nameToShort() throws SQLException {
        try {
            clientService.create("R");
            fail("Expect exception thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must be between 2 and 1000 characters long.", e.getMessage());
        }
    }

    @Test
    public void test_getById_success() throws SQLException {
       long expectedId = 1;
       String expectedName = "Robert";

        ResultSet resultSet = mock(ResultSet.class);
        when(readSt.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getLong("id")).thenReturn(expectedId);
        when(resultSet.getString("name")).thenReturn(expectedName);
        Client result = clientService.getById(expectedId);

        assertEquals(expectedId, result.getId());
        assertEquals(expectedName, result.getName());
    }

    @Test
    public void test_getById_idToShort() throws SQLException {
        try{
           clientService.getById(0);
            fail("Expect exception thrown");
        } catch (IllegalArgumentException e){
            assertEquals("Id must be between 1 and 9,223,372,036,854,775,807 digital input.", e.getMessage());
        }
    }

    @Test
    public void test_setName_success() throws SQLException {
        clientService.setName(1, "Robert");
        verify(updateSt).setLong(2, 1);
        verify(updateSt).setString(1, "Robert");
        verify(updateSt).execute();
    }

    @Test
    public void test_setName_nameToShort() throws SQLException {
        try {
            clientService.setName(1,"R");
            fail("Expect exception thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must be between 2 and 1000 characters long.", e.getMessage());
        }
    }

    @Test
    public void test_deleteById_success() throws SQLException {
        clientService.deleteById(1);
        verify(deleteSt).setLong(1, 1);
        verify(deleteSt).execute();
    }

    @Test
    public void test_deleteById_idToShort() throws SQLException {
        try{
            clientService.deleteById(0);
            fail("Expect exception thrown");
        } catch (IllegalArgumentException e){
            assertEquals("Id must be between 1 and 9,223,372,036,854,775,807 digital input.", e.getMessage());
        }
    }

    @Test
    public void test_listAll_success() throws SQLException {
        long expectedId = 1;
        String expectedName = "Robert";

        ResultSet resultSet = mock(ResultSet.class);
        when(selectSt.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {
                private int count = 0;
                @Override
                public Boolean answer(InvocationOnMock invocation) {
                    return count++ < 2;
                }
        });
        when(resultSet.getLong("id")).thenReturn(expectedId);
        when(resultSet.getString("name")).thenReturn(expectedName);
        List<Client> result = clientService.listAll();

        assertEquals(2, result.size());
    }


}
