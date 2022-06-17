package DAO;

import model.Book;
import model.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAORealization implements BookDAO{

    private Connection connection;

    private String scriptSQL;

    public BookDAORealization() {
        this.connection = new DbConfig().getConnection();
    }

    @Override
    public void addBook(Book book) {
        scriptSQL = "INSERT INTO library (title,author) Values (?, ?)";
        this.connectionWithoutResult(scriptSQL,book);
    }




    @Override
    public void delBook(Book book) {
        scriptSQL =  "DELETE FROM library WHERE title = ? AND author = ?";
        this.connectionWithoutResult(scriptSQL,book);
    }



    @Override
    public Library showLib() {
        Library lib = new Library();
        String scriptSQL = "SELECT * FROM library";

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
                lib.getBooks().add(new Book(resultSet.getString(2), resultSet.getString(3)));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("title"));
                System.out.println(resultSet.getString("author"));
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lib;
    }
    public Library getLib() {
        Library lib = new Library();
        String scriptSQL = "SELECT * FROM library";

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
                lib.getBooks().add(new Book(resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lib;
    }
    private void connectionWithoutResult(String scriptSQL, Book book){

        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
