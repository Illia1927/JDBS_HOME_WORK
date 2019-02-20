package jdbspractise.service;

import jdbspractise.model.User;
import jdbspractise.web.ViewModel;

public interface SecurityService {

    ViewModel doLog(String login, String password);

    boolean doReg(User user);
}
