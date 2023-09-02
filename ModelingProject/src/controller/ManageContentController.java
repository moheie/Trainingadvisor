package controller;

import database.CourseDB;
import entity.course.Course;
import entity.course.material.CourseContent;
import entity.course.material.Exam;
import entity.course.material.Material;
import entity.course.material.Video;
import event.SelectionHandler;
import util.Params;
import view.MainView;
import view.ManageContentView;
import view.menu.MenuItem;

import java.util.Scanner;

public class ManageContentController extends DefaultViewController<ManageContentView> implements SelectionHandler {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new ManageContentView(this.isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                addMaterial();
                break;
            case 2:
                addVideo();
                break;
            case 3:
                navigate("/course/exam/add", getRequestParams());
                break;
            case 4:
                viewContent();
                break;
        }
    }

    private int getCourseId() {
        Params requestParams = getRequestParams();
        int courseId = requestParams.getInt("courseId").orElseThrow();

        return courseId;
    }

    private CourseContent getCourseContent() {
        int courseId = getCourseId();
        Course course = courseDB.get(courseId);

        return course.getContent();
    }

    private void addMaterial() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the URL of the lecture: ");
        Material material = new Material(scanner.nextLine());

        CourseContent content = getCourseContent();
        content.addMaterial(material);

        System.out.println("Lecture added successfully");
    }

    private void addVideo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the URL of the video: ");
        Video video = new Video(scanner.nextLine());

        CourseContent content = getCourseContent();
        content.addVideo(video);

        System.out.println("Video added successfully");
    }

    private void viewContent() {
        CourseContent content = getCourseContent();

        System.out.println("Lectures:");
        System.out.println(content.getMaterials());

        System.out.println("Videos:");
        System.out.println(content.getVideos());

        System.out.println("Exams:");

        int counter = 1;

        for (Exam exam: content.getExams()) {
            System.out.printf("Exam %d\n", counter++);
            exam.displayPreview();
        }
    }
}
