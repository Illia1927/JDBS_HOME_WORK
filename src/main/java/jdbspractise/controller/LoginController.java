package jdbspractise.controller;

import jdbspractise.service.SecurityService;
import jdbspractise.service.UserService;
import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

public class LoginController implements Controller {

    private SecurityService securityService;

    public LoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
////////////////////////////////////////////////
        System.out.println("start login in prosess 1111111111111");
        ///////////////////////////////////////////
        String login = request.getParamByName("login");
        String actualPassword = request.getParamByName("password");

        return securityService.doLog(login, actualPassword);
    }
}
