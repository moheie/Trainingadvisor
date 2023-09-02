package view;

import entity.user.UserDetails;
import util.ValueBinding;

import java.util.Scanner;

public class CreateAccountView extends FormView<UserDetails, Void> {
    private boolean isOwnAccount = false;

    public CreateAccountView(boolean isOwnAccount, ValueBinding<Boolean> active) {
        super(active);
        this.isOwnAccount = isOwnAccount;
    }

    public CreateAccountView(ValueBinding<Boolean> active) {
        super(active);
    }

    private String getPossessivePronoun() {
        if (isOwnAccount) {
            return "your";
        } else {
            return "the user's";
        }
    }

    @Override
    public void display(Void params) {
        Scanner scanner = new Scanner(System.in);
        UserDetails details = new UserDetails();

        String possessivePronoun = getPossessivePronoun();

        System.out.printf("Enter %s name: ", possessivePronoun);
        details.setName(scanner.nextLine());

        System.out.printf("Enter %s password: ", possessivePronoun);
        details.setPassword(scanner.nextLine());

        System.out.printf("Enter %s email: ", possessivePronoun);
        details.setEmail(scanner.nextLine());

        System.out.printf("Enter %s phone: ", possessivePronoun);
        details.setPhone(scanner.nextLine());

        System.out.printf("Enter %s address: ", possessivePronoun);
        details.setAddress(scanner.nextLine());

        System.out.printf("Enter %s photo: ", possessivePronoun);
        details.setPhoto(scanner.nextLine());

        submit(details);
    }
}
