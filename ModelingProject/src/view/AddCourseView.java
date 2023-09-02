package view;

import entity.course.Category;
import entity.course.CourseDetails;
import event.SubmitHandler;
import util.ValueBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddCourseView extends FormView<CourseDetails, Void>  {
    private PrerequisiteEditorView prereqEditorView;
    private CategoryMenu categoryMenu;

    public AddCourseView(ValueBinding<Boolean> active) {
        super(active);
        initialize();
    }

    private void initialize() {
        prereqEditorView = new PrerequisiteEditorView(this.active);
        categoryMenu = new CategoryMenu();
    }

    @Override
    public void display(Void params) {
        Scanner scanner = new Scanner(System.in);
        CourseDetails details = new CourseDetails();

        details.setRatings(0);
        details.setReviews(new ArrayList<>());

        System.out.print("Enter Course Name: ");
        details.setName(scanner.nextLine());

        System.out.print("Enter Course Description: ");
        details.setDescription(scanner.nextLine());

        System.out.print("Enter Course Duration: ");
        details.setDuration(scanner.nextInt());

        System.out.println("Course prerequisites");

        prereqEditorView.onSubmit(new SubmitHandler<List<Integer>>() {
            @Override
            public void handleSubmit(List<Integer> prerequisites) {
                details.setPrerequisites(prerequisites);
            }
        });

        prereqEditorView.display(new ArrayList<>());

        // todo: course cost

        System.out.print("Enter Trainer ID: ");
        details.setTrainerId(scanner.nextInt());

        System.out.println("Choose a category:");
        details.setCategory(categoryMenu.getCategory());

        /* System.out.print("Enter the cost of the course: ");
        details.setCost(scanner.nextFloat()); */

        submit(details);
    }
}
