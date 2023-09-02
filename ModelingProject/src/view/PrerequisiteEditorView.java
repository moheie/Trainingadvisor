package view;

import event.ExitHandler;
import event.SelectionHandler;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrerequisiteEditorView extends FormView<List<Integer>, List<Integer>> {
    MenuView<Void> menuView;

    List<Integer> prerequisites;

    protected PrerequisiteEditorView(ValueBinding<Boolean> active) {
        super(active);
        initialize();
    }

    private void initialize() {
        menuView = new MenuView<Void>(this.active) {
            @Override
            protected void initialize() {
                menu.add(new MenuItem(1, "Add a prerequisite"));
                menu.add(new MenuItem(2, "Remove a prerequisite"));
                menu.add(new MenuItem(3, "View prerequisites"));
            }
        };

        menuView.onExit(new ExitHandler() {
            @Override
            public void handleExit() {
                submit(prerequisites);
            }
        });

        menuView.onMenuSelection(new SelectionHandler() {
            @Override
            public void handleMenuSelection(MenuItem item) {
                handleMenuViewSelection(item);
            }
        });
    }

    private void handleMenuViewSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                addCourse();
                break;
            case 2:
                removeCourse();
                break;
            case 3:
                System.out.printf("Prerequisite course IDs: %s\n", Arrays.toString(prerequisites.toArray()));
                break;
        }
    }

    private void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the course: ");

        int courseId = scanner.nextInt();

        prerequisites.add(courseId);
    }

    private void removeCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the course: ");

        int courseId = scanner.nextInt();
        int index = prerequisites.indexOf(courseId);

        if (index > -1) {
            prerequisites.remove(index);
            System.out.println("Removed course from prerequisites");
        } else {
            System.out.println("Course is not a prerequisite");
        }
    }

    @Override
    public void display(List<Integer> params) {
        prerequisites = new ArrayList<>(params);
        menuView.display(null);
        prerequisites = null;
    }
}
