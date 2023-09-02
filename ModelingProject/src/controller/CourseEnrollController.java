package controller;

import database.CourseDB;
import entity.course.Course;
import entity.course.CourseDetails;
import entity.user.User;
import event.SubmitHandler;
import util.Params;
import view.CourseEnrollView;

public class CourseEnrollController extends ViewController<Void, CourseEnrollView> implements SubmitHandler<Integer> {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new CourseEnrollView(isActive);

        view.onExit(this);
        view.onSubmit(this);
    }

    @Override
    protected Void buildViewParams(Params params) {
        return null;
    }

    @Override
    public void handleSubmit(Integer courseId) {
        Course course = courseDB.get(courseId);

        if (course != null) {
            CourseDetails courseDetails = course.getDetails();
            User user = getSession().getUser();

            boolean canEnroll = true;

            for (Integer prerequisite: courseDetails.getPrerequisites()) {
                if (!user.hasCourse(prerequisite)) {
                    System.out.printf("Missing prerequisite course: %d\n", prerequisite);
                    canEnroll = false;

                    break;
                }
            }

            if (canEnroll) {
                System.out.printf("Successfully enrolled in %s course\n", courseDetails.getName());
                user.addCourse(course);
            }

            navigateBackwards();
        } else {
            System.out.println("Course doesn't exist");
            render();
        }
    }
}
