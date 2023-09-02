package database;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HelpDeskDB {
    private static HelpDeskDB instance = null;
    private List<String> messages;

    private HelpDeskDB() {
        messages = new ArrayList<>();
    }

    public static HelpDeskDB getInstance() { // static method to get instance
        if (instance == null) {
            instance = new HelpDeskDB();
        }

        return instance;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
