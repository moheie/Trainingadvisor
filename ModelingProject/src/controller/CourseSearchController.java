package controller;

import database.CourseDB;
import dto.CourseSearchDTO;
import entity.course.Course;
import event.SubmitHandler;
import util.Params;
import view.CourseEnrollView;
import view.CourseSearchView;

import java.util.List;
import java.util.Optional;

public class CourseSearchController extends ViewController<Void, CourseSearchView> implements SubmitHandler<CourseSearchDTO>  {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new CourseSearchView(isActive);

        view.onExit(this);
        view.onSubmit(this);
    }

    @Override
    protected Void buildViewParams(Params params) {
        return null;
    }

    @Override
    public void handleSubmit(CourseSearchDTO data) {
        List<Course> courses = courseDB.getByCriteria(data);

        if (!courses.isEmpty()) {
            for (Course course : courses) {
                course.display();
            }
        } else {
            System.out.println("No results have been found with your chosen criteria");
        }
    }
}
