package database;

import entity.user.User;
import entity.user.UserDetails;

import java.util.Collection;
import java.util.HashMap;

public class UserDB {
    private static UserDB instance = null;
    private int nextId = 1; // field to generate unique user IDs
    private HashMap<Integer, User> users = new HashMap<Integer, User>();

    // singleton pattern to ensure only one instance of database.UserDB is created
    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }

        return instance;
    }

    public User add(UserDetails userDetails) {
        User user = new User(nextId++, userDetails);

        users.put(user.getId(), user);

        return user;
    }

    public User get(int userId) {
        return users.get(userId);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public boolean delete(int userId) {
        User user = users.remove(userId);

        return user != null;
    }
}
