package controller;

import database.CourseDB;
import entity.Certificate;
import entity.UserCourse;
import entity.course.Course;
import entity.course.CourseDetails;
import entity.user.User;
import event.SelectionHandler;
import util.Params;
import view.LibraryView;
import view.menu.MenuItem;

import java.util.Scanner;

public class LibraryController extends DefaultViewController<LibraryView> implements SelectionHandler {

    @Override
    protected void initialize() {
        view = new LibraryView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                openCourse();
                break;
            case 2:
                viewCourses();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                addRating();
                break;
            case 5:
                addReview();
                break;
            case 6:
                checkProgress();
                break;
            case 7:
                requestCertificate();
                break;
        }
    }

    private void openCourse() {
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        params.put("courseId", scanner.nextInt());

        navigate("/course", params);
    }

    private void viewCourses(){
        Params params = new Params();
        navigate("/course/display",params);
    }

    private void withdraw(){
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        params.put("courseId", scanner.nextInt());

        navigate("/course/withdraw", params);
    }

    private void addRating(){
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        params.put("courseId", scanner.nextInt());

        navigate("/course/ratings", params);
    }

    private void addReview(){
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        params.put("courseId", scanner.nextInt());

        navigate("/course/review", params);
    }

    private void checkProgress(){
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        params.put("courseId", scanner.nextInt());

        navigate("/course/progress", params);
    }

    private void requestCertificate() {
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the course: ");
        int courseId = scanner.nextInt();

        scanner.nextLine();
        //params.put("courseId", scanner.nextInt());

        //navigate("/course/requestCertificate", params);
        User user = getSession().getUser();
        UserCourse userCourse = user.getCourse(courseId);

        if (userCourse == null) {
            System.out.println("You are not registered in this course");
            render();
        } else {
            Certificate certificate = userCourse.getCertificate();

            if (!certificate.isPaid()) {
                System.out.printf("Certificate Cost: $%.2f\n", certificate.getCost());
                System.out.print("Enter your credit card number: ");

                String creditCardNumber = scanner.nextLine();

                System.out.println("Payment successful");
            }

            CourseDB courseDB = CourseDB.getInstance();
            Course course = courseDB.get(courseId);
            CourseDetails details = course.getDetails();

            System.out.println("Certificate Number : " + certificate.getId());
            System.out.println("Course ID: " + course.getId());
            System.out.println("Course Name: " + details.getName());
            System.out.println("Course Description: " + details.getDescription());
            System.out.println("Course Duration: " + details.getDuration() + " weeks");
            System.out.println("Course Trainer ID: " + details.getTrainerId());
        }
    }
}
