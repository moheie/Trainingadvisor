package entity.user;

import app.Session;
import entity.UserCourse;
import entity.course.Course;

import java.util.HashMap;

public class User {
    private int id;
    private UserDetails details;
    private HashMap<Integer, UserCourse> courses = new HashMap<>();

    public User() {
        id = 0;
        details = new UserDetails();
    }

    public User(UserDetails details) {
        this.id = 0;
        this.details = details;
    }

    public User(int id, UserDetails details) {
        this.id = id;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public void addCourse(Course course) {
        UserCourse myCourse = new UserCourse(getId(), course);

        courses.put(course.getId(), myCourse);
    }

    public UserCourse getCourse(int courseId) {
        return courses.get(courseId);
    }

    public boolean hasCourse(int courseId) {
        return getCourse(courseId) != null;
    }

    public void display() {
        System.out.println("User ID: " + getId());
        System.out.println("User Name: " + details.getName());
        System.out.println("User Email: " + details.getEmail());
        System.out.println("User Role: " + details.getRole());
        System.out.println("User Phone: " + details.getPhone());
        System.out.println("User Address: " + details.getAddress());
        System.out.println("User Photo: " + details.getPhoto());
    }
}
