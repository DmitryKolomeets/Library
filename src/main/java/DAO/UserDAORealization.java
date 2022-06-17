package DAO;

import model.Book;
import model.Library;
import model.User;

import java.sql.*;

public class UserDAORealization implements UserDAO {
    private Connection connection;

    private String scriptSQL;

    public UserDAORealization() {
        this.connection = new DbConfig().getConnection();
    }

    @Override
    public void addUser(User user) {
        scriptSQL = "INSERT INTO users (name,surname) Values (?, ?)";
        this.connectionWithoutResultUser(scriptSQL, user);
    }




    public Library showUser() throws SQLException {
        Library lib2 = new Library();
        String scriptSQL = "SELECT * FROM users";

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while(resultSet.next()) {
                lib2.getBooks().add(new Book(resultSet.getString(2), resultSet.getString(3)));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("surname"));
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lib2;
    }

    public Library getUserDB() throws SQLException {
        Library lib2 = new Library();
        String scriptSQL = "SELECT * FROM users";

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while(resultSet.next()) {
                lib2.getUsers().add(new User(resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lib2;
    }

    private void connectionWithoutResultUser(String scriptSQL, User user) {

        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





            public void closeConnection () {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        }