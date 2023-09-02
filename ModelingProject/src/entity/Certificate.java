package entity;

import entity.course.Course;

public class Certificate {
    private static int nextId = 1;

    private int id;
    private int courseId;
    private float cost;
    private boolean paid;

    public Certificate() {
        this.id = nextId++;
        this.paid = false;
    }

    public Certificate(int courseId, float cost) {
        this();

        this.courseId = courseId;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public float getCost() {
        return cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markAsPaid() {
        paid = true;
    }
}
