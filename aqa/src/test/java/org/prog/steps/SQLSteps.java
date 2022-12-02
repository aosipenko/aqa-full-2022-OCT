package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

public class SQLSteps {

    private final static String DROP_USER =
            "delete from PERSONS WHERE id = %s";
    private final static String SQL_PATTERN =
            "select name from PERSONS WHERE id = %s";

    private final static String NEW_USER_SQL =
            "insert into PERSONS (id, name) VALUES ('%s', '%s')";

    @Given("Create user with id {int} and name {string}")
    public void createDBUser(int id, String name) throws ClassNotFoundException, SQLException {
        executeQuery(String.format(NEW_USER_SQL, id, name));
    }

    @Given("Get user with id {string}")
    public void executeTestQuery(String userId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        Statement stmt = con.createStatement();
        ResultSet sqlResults = stmt.executeQuery(String.format(SQL_PATTERN, userId));
        while (sqlResults.next()) {
            String name = sqlResults.getString(1);
            System.out.println(name);
        }
    }

    @Then("clean up user {int}")
    public void dropUser(int id) throws SQLException, ClassNotFoundException {
        executeQuery(String.format(DROP_USER, id));
    }

    private void executeQuery(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        Statement stmt = con.createStatement();
        stmt.execute(sql);
    }
}
