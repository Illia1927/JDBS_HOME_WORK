package jdbspractise.service.impl;

import jdbspractise.model.User;
import jdbspractise.service.SecurityService;
import jdbspractise.service.UserService;
import jdbspractise.web.ViewModel;

import javax.servlet.http.Cookie;

public class SecurityServiceImpl implements SecurityService {
    private final UserService userService;

    public SecurityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel doLog(String login, String password) {
        System.out.println("Start do log 22222222222");


        User user = userService.getByUsername(login);
        String expectePassword = user.getPassword();

        if (user == null) {
            return proccessUnAuthorized();
        }

        if (expectePassword.equals(password)) {
            return proccessAuthorized();
        } else {
            return proccessUnAuthorized();
        }
    }

    @Override
    public boolean doReg(User user) {
        userService.addUser(user);
        return true;
    }

    private ViewModel proccessAuthorized() {
        String userToken = "";
        Cookie cookie = new Cookie("MATE", userToken);
        ViewModel vm = ViewModel.of("home");
        vm.addCookie(cookie);
        return vm;
    }

    private ViewModel proccessUnAuthorized() {
        ViewModel vm = new ViewModel("login");
        vm.addAtribute("err", "incorrect login/password");
        return ViewModel.of("login");
    }
}
