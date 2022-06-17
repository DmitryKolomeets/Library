package DAO;

import model.Book;
import model.Library;

import java.sql.SQLException;

public interface BookDAO {
    public void addBook(Book book);
    public void delBook(Book book);
    public Library showLib() throws SQLException;


}
