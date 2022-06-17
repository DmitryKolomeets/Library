package enums;

public enum Commands {
    ADD("add", "add book to the library"),
    SHOW("show", "show list of books"),
    EXIT("exit", "close the app"),

    DELETE ("delete", "deleting the book"),

    ADDNEWUSER("adduser", "adding new user"),

    SHOWUSER("showuser", "show users list"),

    HELP ("help", "provide list of availible commands");

    public String value;

    public String description;

    Commands(String command, String description) {
        this.value = command;
        this.description = description;
    }
    @Override
    public String   toString() {
        return "Commands{" +
                "value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
