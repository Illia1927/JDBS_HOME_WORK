package jdbspractise.config;

import jdbspractise.controller.LoginController;
import jdbspractise.controller.RegistrationController;
import jdbspractise.dao.UserDao;
import jdbspractise.dao.impl.UserDaoImpl;
import jdbspractise.service.SecurityService;
import jdbspractise.service.UserService;
import jdbspractise.service.impl.SecurityServiceImpl;
import jdbspractise.service.impl.UserServiceImpl;
import jdbspractise.utill.ConnectionUtill;

import java.sql.Connection;

public class Factory {
    private final static Connection CONNECTION;

    private Factory(){

    }

    public static RegistrationController getRegistrationController() {
        return new RegistrationController(getSecurityService());
    }

    static {
        CONNECTION = ConnectionUtill.getConnection();
    }

    public static LoginController getLoginController() {
        return new LoginController(getSecurityService());
    }

    public static SecurityService getSecurityService() {
        return new SecurityServiceImpl(getUserService());
    }

    public static UserService getUserService(){
        return new UserServiceImpl(getUserDao());
    }

    public static UserDao getUserDao(){
        return new UserDaoImpl(CONNECTION);
    }
}
