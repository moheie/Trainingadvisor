package view.menu;

public class MenuItem {
    private int id;
    private String label;

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void display() {
        System.out.printf("%d. %s\n", getId(), getLabel());
    }

    public MenuItem(int id, String label) {
        this.id = id;
        this.label = label;
    }
}
