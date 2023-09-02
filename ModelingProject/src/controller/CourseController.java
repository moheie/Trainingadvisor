package controller;

import database.CourseDB;
import entity.course.Course;
import entity.course.material.CourseContent;
import entity.course.material.Material;
import entity.course.material.Video;
import entity.user.User;
import event.SelectionHandler;
import util.Params;
import view.CourseView;
import view.menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class CourseController extends DefaultViewController<CourseView> implements SelectionHandler {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new CourseView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    private int getCourseId() {
        Params requestParams = getRequestParams();
        int courseId = requestParams.getInt("courseId").orElseThrow();

        return courseId;
    }

    private Course getCourse() {
        int courseId = getCourseId();
        Course course = courseDB.get(courseId);

        return course;
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                displayMaterials();
                break;
            case 2:
                displayVideos();
                break;
            case 3:
                takeAnExam();
                break;
        }
    }

    public void displayMaterials() {
        Course course = getCourse();
        CourseContent content = course.getContent();

        List<Material> materials = content.getMaterials();
        int counter = 1;

        for (Material material: materials) {
            System.out.printf("Lecture %d: %s\n", counter++, material.getUrl());
        }
    }

    public void displayVideos() {
        Course course = getCourse();
        CourseContent content = course.getContent();

        List<Video> videos = content.getVideos();
        int counter = 1;

        for (Video video: videos) {
            System.out.printf("Video %d: %s\n", counter++, video.getUrl());
        }
    }

    public void takeAnExam() {
        Scanner scanner = new Scanner(System.in);
        Params params = new Params();

        System.out.print("Enter the ID of the exam: ");

        params.put("examId", scanner.nextInt());
        params.put("courseId", getCourseId());

        navigate("/course/exam", params);
    }

    @Override
    public void render() {
        Course course = getCourse();
        User user = getSession().getUser();

        if (course != null) {
            if (user.hasCourse(course.getId())) {
                super.render();
            } else {
                System.out.println("You are not enrolled in this course");
            }
        } else {
            System.out.println("Course doesn't exist");
        }

        navigateBackwards();
    }
}
