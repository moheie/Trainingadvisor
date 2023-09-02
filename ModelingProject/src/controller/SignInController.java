package controller;

import app.Session;
import database.UserDB;
import dto.LoginDTO;
import entity.user.User;
import entity.user.UserDetails;
import event.SubmitHandler;
import view.SignInView;

public class SignInController extends DefaultViewController<SignInView> implements SubmitHandler<LoginDTO> {
    private UserDB userDB = UserDB.getInstance();

    @Override
    protected void initialize() {
        view = new SignInView(isActive);

        view.onSubmit(this);
    }

    @Override
    public void handleSubmit(LoginDTO loginDTO) {
        User user = userDB.get(loginDTO.getUserId());

        if (user != null) {
            UserDetails userDetails = user.getDetails();

            if (loginDTO.getPassword().equals(userDetails.getPassword())) {
                Session session = Session.getInstance();

                session.setUser(user);

                System.out.println("Login successful!");
                System.out.printf("Welcome, %s\n", userDetails.getName());

                switch (userDetails.getRole()) {
                    case TRAINEE:
                        navigate("/trainee");
                        break;
                    case TRAINER:
                        navigate("/trainer");
                        break;
                    case ADMIN:
                        navigate("/admin");
                        break;
                }

                return;
            }
        }

        System.out.println("Invalid credentials, please try again");
        render();
    }
}
