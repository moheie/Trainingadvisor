package app;

import controller.*;
import router.Router;

public class Application {
    private Router router = new Router();

    public Application() {
        router = new Router();

        router.register("/", new MainController());
        router.register("/help", new HelpDeskController());

        router.register("/signIn", new SignInController());
        router.register("/signUp", new SignUpController());

        router.register("/trainee", new TraineeController());
        router.register("/library", new LibraryController());

        router.register("/account/manage", new ManageAccountController());

        router.register("/course", new CourseController());
        router.register("/course/add", new AddCourseController());
        // router.register("/course/edit", new CourseEditController);
        router.register("/course/search", new CourseSearchController());
        router.register("/course/enroll", new CourseEnrollController());
        router.register("/course/exam", new ExamController());
        router.register("/course/exam/add", new AddExamController());
        router.register("/course/content/manage", new ManageContentController());

        router.register("/admin", new AdminController());
        router.register("/admin/manageAccounts", new ManageAccountsController());
        router.register("/admin/manageCourses", new ManageCoursesController());
    }

    public void start() {
        router.navigate("/");
    }
}
