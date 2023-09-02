package controller;

import database.HelpDeskDB;
import event.SelectionHandler;
import view.HelpDeskView;
import view.menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class HelpDeskController extends DefaultViewController<HelpDeskView> implements SelectionHandler {
    private HelpDeskDB helpDeskDB = HelpDeskDB.getInstance();

    @Override
    protected void initialize() {
        view = new HelpDeskView(isActive);

        view.onMenuSelection(this);
        view.onExit(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                // write message
                this.handleWriteMessage();
                break;
            case 2:
                // view messages
                this.handleViewMessages();
                break;
        }
    }

    private void handleWriteMessage() {
        System.out.print("Enter a message: ");

        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        helpDeskDB.addMessage(message);
    }

    private void handleViewMessages() {
        List<String> messages = helpDeskDB.getMessages();

        if (messages.isEmpty()) {
            System.out.println("No messages found.");
        } else {
            for (String message: messages) {
                System.out.println(message);
            }
        }
    }
}
