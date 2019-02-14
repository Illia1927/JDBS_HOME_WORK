package jdbspractise.controller;

import jdbspractise.model.User;
import jdbspractise.service.UserService;
import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

public class RegistrationController implements Controller {
    private UserService userService;
    public RegistrationController(UserService userService) {
    }

    @Override
    public ViewModel process(Request request) {
        String login = request.getParamByName("login");
        String password = request.getParamByName("password");
        String name = request.getParamByName("name");
        String email = request.getParamByName("email");
        User user = new User(login, password, name, email);
        userService.addUser(user);
        System.out.println(user.toString());
        return ViewModel.of("home");
    }
}
