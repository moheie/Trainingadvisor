package database;

import dto.CourseSearchDTO;
import entity.course.Course;
import entity.course.CourseDetails;

import java.util.*;

public class CourseDB {
    private static CourseDB instance = null;

    private int nextId = 1; // field to generate unique course IDs

    private HashMap<Integer, Course> courses = new HashMap<Integer, Course>();

    // singleton pattern to ensure only one instance of database.CourseDB is created
    public static CourseDB getInstance() {
        if (instance == null) {
            instance = new CourseDB();
        }

        return instance;
    }

    public Course add(CourseDetails courseDetails) {
        Course course = new Course(nextId++, courseDetails);

        courses.put(course.getId(), course);

        return course;
    }

    public Course get(int courseId) {
        return courses.get(courseId);
    }

    public Collection<Course> getAll() {
        return Collections.unmodifiableCollection(courses.values());
    }

    public List<Course> getByCriteria(CourseSearchDTO criteria) {
        List<Course> results = new ArrayList<>();

        for (Course course: courses.values()) {
            if (course.matches(criteria)) {
                results.add(course);
            }
        }

        return results;
    }

    public boolean delete(int courseId) {
        Course course = courses.remove(courseId);

        return course != null;
    }
}
