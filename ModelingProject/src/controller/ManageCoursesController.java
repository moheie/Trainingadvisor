package controller;

import database.CourseDB;
import entity.course.Course;
import entity.user.User;
import event.SelectionHandler;
import util.Params;
import view.ManageCoursesView;
import view.menu.MenuItem;

import java.util.Collection;
import java.util.Scanner;

public class ManageCoursesController extends DefaultViewController<ManageCoursesView> implements SelectionHandler {
    CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new ManageCoursesView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                displayAllCourses();
                break;
            case 2:
                navigate("/course/add");
                break;
            case 3:
                readCourseAndNavigate("/course/content/manage");
                break;
            case 4:
                deleteCourse();
                break;
            case 5:
                readCourseAndNavigate("/course/edit");
                break;
        }
    }

    private void displayAllCourses() {
        Collection<Course> courses = courseDB.getAll();
        int counter = 1;

        for (Course course: courses) {
            System.out.printf("Course %d:\n", counter++);
            course.display();
        }
    }

    private Course readCourse() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the course ID: ");

            int id = scanner.nextInt();
            Course course = courseDB.get(id);

            scanner.nextLine();

            if (course != null) {
                return course;
            } else {
                System.out.println("Course doesn't exist");
            }
        }
    }

    private void readCourseAndNavigate(String path) {
        Course course = readCourse();

        Params params = new Params();
        params.put("courseId", course.getId());

        navigate(path, params);
    }

    private void deleteCourse() {
        Course course = readCourse();

        courseDB.delete(course.getId());
        System.out.println("Course has been deleted");
    }
}
