package jdbspractise.controller;

import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

import javax.servlet.http.Cookie;

public class LogoutController implements Controller {
    @Override
    public ViewModel process(Request request) {
        Cookie cookie = new Cookie("MATE", "");
        cookie.setMaxAge(0);
        ViewModel vm = ViewModel.of("login");
        vm.addCookie(cookie);
        return vm;
    }
}
