package com.epam.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ConnectionFactoryTest {
    private static ConnectionFactory connectionFactory;

    @BeforeClass
    public static void onlyOnce() {
        connectionFactory = ConnectionFactory.getInstance();
    }

    @Test
    public void get_Connection_Method_Should_Not_Return_Null() throws SQLException {
        assertThat(connectionFactory.getConnection(), notNullValue());
    }

    @Test
    public void get_Instance_Method_Should_Not_Return_Null() {
        assertThat(ConnectionFactory.getInstance(), notNullValue());
    }


}