package view;

import dto.CourseSearchDTO;
import entity.course.Category;
import event.ExitHandler;
import event.SelectionHandler;
import util.ValueBinding;
import view.menu.Menu;
import view.menu.MenuItem;
import view.menu.MenuView;

import java.util.Scanner;

public class CourseSearchView extends FormView<CourseSearchDTO, Void> {
    private MenuView<Void> criteriaMenu;
    private CategoryMenu categoryMenu;
    private CourseSearchDTO dto;

    public CourseSearchView(ValueBinding<Boolean> active) {
        super(active);
        initialize();
    }

    private void initialize() {
        criteriaMenu = new MenuView<Void>(active) {
            @Override
            protected void initialize() {
                menu.add(new MenuItem(1, "Category"));
                menu.add(new MenuItem(2, "Ratings"));
                menu.add(new MenuItem(3, "Course ID"));
                menu.add(new MenuItem(4, "Course Name"));
                menu.add(new MenuItem(5, "Submit"));
            }
        };

        criteriaMenu.onExit(new ExitHandler() {
            @Override
            public void handleExit() {
                close();
            }
        });

        criteriaMenu.onMenuSelection(new SelectionHandler() {
            @Override
            public void handleMenuSelection(MenuItem item) {
                handleCriteriaMenuSelection(item);
            }
        });

        categoryMenu = new CategoryMenu();
        categoryMenu.add(Menu.EXIT_MENU_ITEM);
    }

    private void handleCriteriaMenuSelection(MenuItem item) {
        Scanner scanner = new Scanner(System.in);

        switch (item.getId()) {
            case 1:
                System.out.println("Choose a category:");
                Category category = categoryMenu.getCategory();

                if (category == null) {
                    return;
                }

                dto.setCategory(category);
                break;
            case 2:
                System.out.print("Enter Minimum Rating: ");
                Float minRating = scanner.nextFloat();

                scanner.nextLine(); // skip
                dto.setRatings(minRating);
                break;
            case 3:
                System.out.print("Enter course ID: ");
                int id = scanner.nextInt();

                scanner.nextLine(); // skip
                dto.setCourseId(id);
                break;
            case 4:
                System.out.print("Enter course name: ");

                String name = scanner.nextLine();
                dto.setCourseName(name);
                break;
            case 5:
                submit(dto);
                dto = new CourseSearchDTO(); // reset criteria
                break;
        }
    }

    @Override
    public void display(Void params) {
        System.out.println("Edit search criteria");

        dto = new CourseSearchDTO();
        criteriaMenu.display(params);
        dto = null;
    }
}
