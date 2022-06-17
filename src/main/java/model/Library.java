package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class Library {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

}
