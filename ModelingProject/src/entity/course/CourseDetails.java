package entity.course;

import java.util.ArrayList;
import java.util.List;

public class CourseDetails {
    private String name;
    private String description;
    private int duration;
    private int ratingNumber = 0;
    private float ratings;
    private List<Integer> prerequisites;
    // private Certificate certificate;
    private List<String> reviews;
    private int trainerId;
    private Category category;
    private int certificateCost;

    public CourseDetails(String name, String description, int duration, int ratingNumber, float ratings, List<Integer> prerequisites, List<String> reviews, int trainerId, Category category, int certCost) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.ratingNumber = ratingNumber;
        this.ratings = ratings;
        this.prerequisites = prerequisites;
        this.reviews = reviews;
        this.trainerId = trainerId;
        this.category = category;
        this.certificateCost = certCost;
    }

    public CourseDetails() {
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public List<Integer> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Integer> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCertificateCost() {
        return certificateCost;
    }

    public void setCertificateCost(int certificateCost) {
        this.certificateCost = certificateCost;
    }
}
