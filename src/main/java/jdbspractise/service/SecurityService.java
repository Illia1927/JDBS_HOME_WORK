package jdbspractise.service;

import jdbspractise.model.User;

public interface SecurityService {

    public boolean doLog(String login, String password);

    public boolean doReg(User user);
}
