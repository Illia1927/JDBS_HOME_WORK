package jdbspractise.web;

import jdbspractise.controller.Controller;
import jdbspractise.controller.HomeController;
import jdbspractise.controller.LoginController;
import jdbspractise.controller.RegistrationController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static jdbspractise.web.Request.RequestMathod.GET;

public class MainServlet extends HttpServlet {
    private final static Map<Request, Controller> controllers = new HashMap<>();

    static {
        controllers.put(Request.of("/servlet/login", GET), new LoginController());
        controllers.put(Request.of("/servlet/registration", GET), new RegistrationController());
        controllers.put(Request.of("/servlet/home", GET), new HomeController());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath() + req.getPathInfo();
        Request request = Request.of(path, Request.RequestMathod.valueOf(req.getMethod()));
        Controller controller = controllers.get(request);
        ViewModel vm = controller.process();
        sendResponse(vm, req, resp);
    }

    private void sendResponse(ViewModel vm, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirectUrl = "/WEB-INF/views/%s.jsp";
        vm.getModel().forEach(request::setAttribute);
        request.getRequestDispatcher(String.format(redirectUrl, vm.getView()))
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
