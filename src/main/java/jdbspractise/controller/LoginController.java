package jdbspractise.controller;

import jdbspractise.service.SecurityService;
import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

public class LoginController implements Controller {

    private SecurityService securityService;

    public LoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
        String login = request.getParamByName("login");
        String actualPassword = request.getParamByName("password");

        return securityService.doLog(login, actualPassword);
    }
}
