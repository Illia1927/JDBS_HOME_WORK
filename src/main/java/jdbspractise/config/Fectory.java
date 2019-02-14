package jdbspractise.config;

import jdbspractise.controller.RegistrationController;
import jdbspractise.dao.UserDao;
import jdbspractise.dao.impl.UserDaoImpl;
import jdbspractise.service.UserService;
import jdbspractise.service.impl.UserServiceImpl;
import jdbspractise.utill.ConnectionUtill;

import java.sql.Connection;

public class Fectory {
    private final static Connection CONNECTION;
    private Fectory(){}
    public static RegistrationController getRegistrationController(){
        return new RegistrationController(getUserService());
    }

    static {
        CONNECTION = ConnectionUtill.getConnection();
    }

    public static UserService getUserService(){
        return new UserServiceImpl(getUserDao());
    }

    public static UserDao getUserDao(){
        return new UserDaoImpl(CONNECTION);
    }
}
