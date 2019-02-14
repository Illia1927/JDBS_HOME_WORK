package jdbspractise.controller;

import jdbspractise.model.User;
import jdbspractise.service.UserService;
import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

import javax.servlet.http.Cookie;

public class LoginController implements Controller {
    private UserService userService;

    @Override
    public ViewModel process(Request request) {
        ViewModel viewModel = new ViewModel("login");
        String login = request.getParamByName("user_id");
        User user = userService.getByUsername(login);
        String actualPassword = request.getParamByName("password");
        String expectePassword = user.getPassword();

        if (user == null) {
            return proccessUnAuthorized();
        }

        if (expectePassword.equals(actualPassword)) {
            return proccessAuthorized();
        } else {
            return proccessUnAuthorized();
        }
    }

    private ViewModel proccessAuthorized() {
        String userToken = "";
        Cookie cookie = new Cookie("MATE", userToken);
        ViewModel vm = ViewModel.of("home");
        vm.AddCookie(cookie);
        return ViewModel.of("home");
    }

    private ViewModel proccessUnAuthorized() {
        ViewModel vm = new ViewModel("login");
        vm.addAtribute("err", "incorrect login/password");
        return ViewModel.of("login");
    }
}
