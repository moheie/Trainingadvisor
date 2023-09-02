package view;

import dto.LoginDTO;
import util.Params;
import util.ValueBinding;

import java.util.Scanner;

public class SignInView extends FormView<LoginDTO, Void> {
    public SignInView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    public void display(Void params) {
        Scanner scanner = new Scanner(System.in);
        LoginDTO loginDTO = new LoginDTO();

        int userId;
        String password;

        System.out.print("Enter your id: ");
        userId = scanner.nextInt();

        if (userId == 0) {
            close();
            return;
        }

        scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        loginDTO.setUserId(userId);
        loginDTO.setPassword(password);

        submit(loginDTO);
    }
}
