package entity.course;

import dto.CourseSearchDTO;
import entity.course.material.CourseContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Course {
    private int id;
    private CourseDetails details;
    private CourseContent content;
    private QuestionBank questionBank;

    public Course(int id, CourseDetails details) {
        this.id = id;
        this.details = details;
        this.content = new CourseContent();
        this.questionBank = new QuestionBank();
    }

    public Course() {
        this.id = 0;
        this.details = new CourseDetails();
    }

    public int getId() {
        return id;
    }

    public CourseDetails getDetails() {
        return details;
    }

    public CourseContent getContent() {
        return content;
    }

    public QuestionBank getQuestionBank() {
        return questionBank;
    }

    public boolean matches(CourseSearchDTO searchDTO) {
        Optional<Integer> courseId = searchDTO.getCourseId();
        Optional<String> courseName = searchDTO.getCourseName();
        Optional<Category> category = searchDTO.getCategory();
        Optional<Float> minRating = searchDTO.getRatings();

        if (courseId.isPresent() && !courseId.get().equals(id)) {
            return false;
        }

        if (courseName.isPresent() && !courseName.get().equals(details.getName())) {
            return false;
        }

        if (category.isPresent() && !category.get().equals(details.getCategory())) {
            return false;
        }

        if (minRating.isPresent() && details.getRatings() < minRating.get()) {
            return false;
        }

        return true;
    }

    public void display() {
        System.out.println("Course ID: " + getId());
        System.out.println("Course Name: " + details.getName());
        System.out.println("Course Description: " + details.getDescription());
        System.out.println("Course Duration: " + details.getDuration() + " weeks");
        System.out.println("Course Ratings: " + details.getRatings());
        System.out.println("Course Prerequisites: " + details.getPrerequisites());
        System.out.println("Course Trainer ID: " + details.getTrainerId());
        System.out.println("Course Reviews: " + details.getReviews());
        System.out.println("Course Category: " + details.getCategory());
    }
}
