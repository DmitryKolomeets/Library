package service;

import DAO.BookDAORealization;
import DAO.UserDAORealization;
import enums.Commands;
import model.Book;
import model.Library;
import model.User;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class CommandService {

    Library lib = new Library();
    Library libUser = new Library();
    Scanner in = new Scanner(System.in);
    Book book;
    User user;
    String str;
    BookDAORealization bookDAO = new BookDAORealization();
    UserDAORealization userDAO = new UserDAORealization();


    {
        lib = bookDAO.getLib();

    }


    public Consumer<Scanner> showAllBooks() {

        return scanner -> {
            bookDAO.showLib();

        };
    }


    public Consumer<Scanner> addBook() {
        return scanner -> {
            book = new Book();

            System.out.println("Do You want add new book?");
            System.out.println("Enter a book Title:");
            book.setTitle(in.nextLine());

            System.out.println("Enter a book Author:");
            book.setAuthor(in.nextLine());

            System.out.println("You added new Book");
            System.out.println("Title: " + book.getTitle() + " - Author: " + book.getAuthor());

            lib.getBooks().add(book);
            bookDAO.addBook(book);

        };
    }

    public Consumer<Scanner> Help() {
        return scanner -> {
            Arrays.stream(Commands.values()).forEach(System.out::println);
        };
    }

    public Consumer<Scanner> exit() {
        return scanner -> {
            bookDAO.closeConnection();
            System.out.println("exit is initialized....");
        };

    }

    public Consumer<Scanner> delete() {

        return scanner -> {


            System.out.println("Delete book");
            System.out.println("Enter a book Title or Author:");
            str = in.nextLine();

            Iterator<Book> i = lib.getBooks().iterator();
            while (i.hasNext()) {
                Book checkBook = i.next();
                if (checkBook.getTitle().equals(str) || checkBook.getAuthor().equals(str)) {
                    System.out.println("Book: " + checkBook.getTitle() + " - " + checkBook.getAuthor() + " was deleted\n");
                    book = checkBook;
                }
            }
            lib.getBooks().remove(book);

            bookDAO.delBook(book);
        };

    }


    public Consumer<Scanner> addUser() {

        return scanner -> {
            user = new User();

            System.out.println("Do You want add new user?");
            System.out.println("Enter a name:");
            user.setName(in.nextLine());

            System.out.println("Enter a surname:");
            user.setSurname(in.nextLine());

            System.out.println("You added new USer");
            System.out.println("Name: " + user.getName() + " - Surname: " + user.getSurname());

            lib.getUsers().add(user);
            userDAO.addUser(user);

        };
    }

    public Consumer<Scanner> showUsersList() {

        return scanner -> {

            try {
                userDAO.showUser();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        };
    }


}