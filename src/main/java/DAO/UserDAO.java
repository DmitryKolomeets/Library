package DAO;

import model.Library;
import model.User;

import java.sql.SQLException;

public interface UserDAO {

    public void addUser(User user);
    public Library showUser() throws SQLException;


}
