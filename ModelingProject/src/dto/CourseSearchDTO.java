package dto;

import entity.course.Category;

import java.util.Optional;

public class CourseSearchDTO {
    private Optional<Category> category = Optional.empty();
    private Optional<Float> ratings = Optional.empty();
    private Optional<Integer> courseId = Optional.empty();
    private Optional<String> courseName = Optional.empty();

    public Optional<Category> getCategory() {
        return category;
    }

    public Optional<Float> getRatings() {
        return ratings;
    }

    public Optional<Integer> getCourseId() {
        return courseId;
    }

    public Optional<String> getCourseName() {
        return courseName;
    }

    public void setCategory(Category category) {
        this.category = Optional.of(category);
    }

    public void setRatings(Float ratings) {
        this.ratings = Optional.of(ratings);
    }

    public void setCourseId(Integer courseId) {
        this.courseId = Optional.of(courseId);
    }

    public void setCourseName(String courseName) {
        this.courseName = Optional.of(courseName);
    }
}
