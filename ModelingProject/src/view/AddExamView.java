package view;

import dto.CreateExamDTO;
import event.ExitHandler;
import event.SelectionHandler;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

import java.util.List;
import java.util.Scanner;

public class AddExamView extends FormView<CreateExamDTO, Void> {
    private MenuView<Void> menuView;
    private CreateExamDTO dto;

    public AddExamView(ValueBinding<Boolean> active) {
        super(active);
        initialize();
    }

    private void initialize() {
        menuView = new MenuView<Void>(active) {
            @Override
            protected void initialize() {
                menu.add(new MenuItem(1, "Add an MCQ Question"));
                menu.add(new MenuItem(2, "Remove an MCQ Question"));
                menu.add(new MenuItem(3, "Add a True or False question"));
                menu.add(new MenuItem(4, "Remove a True or False question"));
                menu.add(new MenuItem(5, "Save"));
            }
        };

        menuView.onExit(new ExitHandler() {
            @Override
            public void handleExit() {
                close();
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
                addMCQ();
                break;
            case 2:
                removeMCQ();
                break;
            case 3:
                addTOF();
                break;
            case 4:
                removeTOF();
                break;
            case 5:
                submit(dto);
                dto = new CreateExamDTO(); // reset
                break;
        }
    }

    private void addMCQ() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an MCQ Question ID: ");

        int id = scanner.nextInt();
        scanner.nextLine(); // skip

        dto.addMCQ(id);
    }

    private void removeMCQ() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an MCQ Question ID: ");

        int id = scanner.nextInt();
        scanner.nextLine(); // skip

        List<Integer> mcqList = dto.getMcqList();
        int index = mcqList.indexOf(id);

        if (index > -1) {
            mcqList.remove(index);
            System.out.println("Removed MCQ question");
        } else {
            System.out.println("MCQ question does not exist inside this exam");
        }
    }

    private void addTOF() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a TOF Question ID: ");

        int id = scanner.nextInt();
        scanner.nextLine(); // skip

        dto.addTrueOrFalse(id);
    }

    private void removeTOF() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a TOF Question ID: ");

        int id = scanner.nextInt();
        scanner.nextLine(); // skip

        List<Integer> tofList = dto.getTofList();
        int index = tofList.indexOf(id);

        if (index > -1) {
            tofList.remove(index);
            System.out.println("Removed True or False question");
        } else {
            System.out.println("True or False question does not exist inside this exam");
        }
    }

    @Override
    public void display(Void params) {
        dto = new CreateExamDTO();
        menuView.display(params);
        dto = null;
    }
}
