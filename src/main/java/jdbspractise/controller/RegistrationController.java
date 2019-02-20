package jdbspractise.controller;

import jdbspractise.model.User;
import jdbspractise.service.SecurityService;
import jdbspractise.web.PassEncoder;
import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

public class RegistrationController implements Controller {

    private SecurityService securityService;

    public RegistrationController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
        String login = request.getParamByName("login");
        String name = request.getParamByName("name");
        String email = request.getParamByName("email");
        String password = PassEncoder.encode(request.getParamByName("password"));

        User user = new User(login, name, email, password);

        securityService.doReg(user);

        return ViewModel.of("login");
    }
}
