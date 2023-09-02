package controller;

import database.UserDB;
import entity.user.User;
import entity.user.UserDetails;
import event.SubmitHandler;
import view.CreateAccountView;

public class SignUpController extends DefaultViewController<CreateAccountView> implements SubmitHandler<UserDetails> {
    private UserDB userDB = UserDB.getInstance();

    @Override
    protected void initialize() {
        view = new CreateAccountView(true, isActive);

        view.onSubmit(this);
    }

    @Override
    public void handleSubmit(UserDetails data) {
        User user = userDB.add(data);

        System.out.printf("Registration complete! Your user ID is %d\n", user.getId());
        navigateBackwards();
    }
}
