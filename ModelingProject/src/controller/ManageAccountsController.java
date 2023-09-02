package controller;

import database.UserDB;
import entity.user.Role;
import entity.user.User;
import entity.user.UserDetails;
import event.ExitHandler;
import event.SelectionHandler;
import event.SubmitHandler;
import view.ManageAccountsView;
import view.CreateAccountView;
import view.menu.Menu;
import view.menu.MenuItem;

import java.util.Collection;
import java.util.Scanner;

public class ManageAccountsController extends DefaultViewController<ManageAccountsView> implements SelectionHandler {
    private UserDB userDB = UserDB.getInstance();

    @Override
    protected void initialize() {
        view = new ManageAccountsView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                displayAllAccounts();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                deleteAccount();
                break;
            case 4:
                changeAccountRole();
                break;
            case 5:
                navigate("/account/manage");
                break;
        }
    }

    private void displayAllAccounts() {
        Collection<User> users = userDB.getAll();
        int counter = 1;

        for (User user: users) {
            System.out.printf("User %d:\n", counter++);
            user.display();
        }
    }

    private Menu createRoleMenu() {
        Menu menu = new Menu();

        menu.add(new MenuItem(1, "Trainee"));
        menu.add(new MenuItem(2, "Trainer"));
        menu.add(new MenuItem(3 ,"Admin"));

        return menu;
    }

    private Role chooseRole() {
        MenuItem item = createRoleMenu().display();
        Role role = Role.TRAINEE;

        switch (item.getId()) {
            case 1:
                role = Role.TRAINEE;
                break;
            case 2:
                role = Role.TRAINER;
                break;
            case 3:
                role = Role.ADMIN;
                break;
        }

        return role;
    }

    private void createAccount() {
        CreateAccountView createAccountView = new CreateAccountView(false, this.isActive);

        createAccountView.onExit(new ExitHandler() {
            @Override
            public void handleExit() {
                render();
            }
        });

        createAccountView.onSubmit(new SubmitHandler<UserDetails>() {
            @Override
            public void handleSubmit(UserDetails userDetails) {
                System.out.println("Choose a role:");

                Role role = chooseRole();
                userDetails.setRole(role);

                User user = userDB.add(userDetails);

                System.out.printf("User has been created with ID %d\n", user.getId());
            }
        });

        createAccountView.display(null);
    }

    private void deleteAccount() {
        System.out.print("Enter Account ID: ");

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        if (userDB.delete(id)) {
            System.out.printf("User with ID %d has been deleted\n", id);
        } else {
            System.out.println("User does not exist");
        }
    }

    private void changeAccountRole() {
        System.out.print("Enter Account ID: ");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        User user = userDB.get(id);

        if (user != null) {
            if (id != getSession().getUser().getId()) {
                Role role = chooseRole();

                user.getDetails().setRole(role);
                System.out.println("User role has been updated");
            } else {
                System.out.println("You cannot change your own role");
            }
        } else {
            System.out.println("User doesn't exist");
            changeAccountRole();
        }
    }
}
