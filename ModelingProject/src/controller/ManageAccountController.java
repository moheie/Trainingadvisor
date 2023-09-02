package controller;

import app.Session;
import entity.user.User;
import entity.user.UserDetails;
import event.SelectionHandler;
import view.ManageAccountView;
import view.menu.MenuItem;

import java.util.Scanner;

public class ManageAccountController extends DefaultViewController<ManageAccountView> implements SelectionHandler  {
    @Override
    protected void initialize() {
        view = new ManageAccountView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        Session session = getSession();

        User user = session.getUser();
        UserDetails details = user.getDetails();

        Scanner scanner = new Scanner(System.in);

        switch (item.getId()) {
            case 1:
                System.out.print("Enter name: ");
                details.setName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter password: ");
                details.setPassword(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter email: ");
                details.setEmail(scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter phone: ");
                details.setPhone(scanner.nextLine());
                break;
            case 5:
                System.out.print("Enter photo: ");
                details.setPhoto(scanner.nextLine());
                break;
            case 6:
                System.out.print("Enter address: ");
                details.setAddress(scanner.nextLine());
                break;
        }

        System.out.println();
        System.out.println("User updated! Here's your current profile information:");

        user.display();
    }
}
