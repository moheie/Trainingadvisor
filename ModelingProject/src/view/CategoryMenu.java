package view;

import entity.course.Category;
import view.menu.Menu;
import view.menu.MenuItem;

public class CategoryMenu extends Menu {
    public CategoryMenu() {
        add(new MenuItem(1, "Programming"));
        add(new MenuItem(2, "Cooking"));
        add(new MenuItem(3, "Soft Skills"));
        add(new MenuItem(4, "Sales and Marketing"));
        add(new MenuItem(5, "Leadership and Management"));
    }

    public Category getCategory() {
        MenuItem item = display();
        Category category = null;

        switch (item.getId()) {
            case 1:
                category = Category.PROGRAMMING;
                break;
            case 2:
                category = Category.COOKING;
                break;
            case 3:
                category = Category.SOFT_SKILLS;
                break;
            case 4:
                category = Category.SALES_AND_MARKETING;
                break;
            case 5:
                category = Category.LEADERSHIP_AND_MANAGEMENT;
                break;
        }

        return category;
    }
}
