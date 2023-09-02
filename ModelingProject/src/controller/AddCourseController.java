package controller;

import database.CourseDB;
import entity.course.Course;
import entity.course.CourseDetails;
import event.SubmitHandler;
import view.AddCourseView;

public class AddCourseController extends DefaultViewController<AddCourseView> implements SubmitHandler<CourseDetails> {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new AddCourseView(this.isActive);

        view.onExit(this);
        view.onSubmit(this);
    }

    @Override
    public void handleSubmit(CourseDetails details) {
        Course course = courseDB.add(details);

        System.out.printf("A new course has been created with id %d\n", course.getId());
        navigateBackwards();
    }
}
