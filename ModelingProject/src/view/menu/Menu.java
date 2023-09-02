package view.menu;

import event.SelectionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    public static MenuItem EXIT_MENU_ITEM = new MenuItem(0, "Exit");
    private static HashMap<Integer, MenuItem> mapItemsToMap(List<MenuItem> itemList) {
        HashMap<Integer, MenuItem> itemMap = new HashMap<>();

        for (MenuItem item: itemList) {
            itemMap.put(item.getId(), item);
        }

        return itemMap;
    }

    private SelectionHandler selectionHandler;
    protected HashMap<Integer, MenuItem> items;
    protected List<Integer> itemIdList;

    public Menu(List<MenuItem> items) {
        this.items = mapItemsToMap(items);
        this.itemIdList = items.stream()
                .map((item) -> item.getId())
                .collect(Collectors.toList());
    }

    public Menu() {
        this.items = new HashMap<>();
        this.itemIdList = new ArrayList<>();
    }

    private MenuItem get(int id) {
        return this.items.get(id);
    }

    public void add(MenuItem item) {
        int itemId = item.getId();

        this.items.put(itemId, item);
        this.itemIdList.add(itemId);
    }

    public MenuItem display() {
        Scanner scanner = new Scanner(System.in);

        MenuItem item;
        int choice;

        while (true) {
            for (Integer currItemId : itemIdList) {
                MenuItem currItem = get(currItemId);

                currItem.display();
            }

            choice = scanner.nextInt();
            item = get(choice);

            if (item != null) {
                return item;
            } else {
                System.out.println("Invalid choice, please try again");
            }
        }
    }
}
