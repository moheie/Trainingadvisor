package view;

import util.ValueBinding;

import java.util.Scanner;

public class CourseEnrollView extends FormView<Integer, Void> {
    public CourseEnrollView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    public void display(Void params) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course ID: ");

        int id = scanner.nextInt();

        if (id != 0) {
            submit(id);
        } else {
            close();
        }
    }
}
