package jdbspractise.controller;

import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

import javax.servlet.ServletException;
import java.io.IOException;

public interface Controller {

    ViewModel process(Request request)
            throws ServletException, IOException;
}
