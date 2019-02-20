package jdbspractise.web.filter;

import jdbspractise.config.Factory;
import jdbspractise.dao.UserDao;
import jdbspractise.model.Role;
import jdbspractise.model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserFilter implements Filter {

    private UserDao userDao;
    private Map<String, String> protectedUrls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = Factory.getUserDao();
        protectedUrls.put("/servlet/home", "ADMIN");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies = req.getCookies();
        String token = null;

        if (cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("MATE") && (c.getName() != null && !c.getValue().equals(""))) {
                    token = c.getValue();
                }
            }
        }
        String path = req.getServletPath() + req.getPathInfo();
        if (token == null) {
            if (path.equals("/servlet/login") || path.equals("/servlet/registration") || path.equals("/servlet/404")) {
                proccessAuthorized(req, res, filterChain);
            } else {
                proccessUnAuthorized(req, res);
            }
        } else {
            User u = userDao.findByToken(token);
            u.setRoles(new Role("ADMIN"));
            if (u == null) {
                proccessUnAuthorized(req, res);
            } else {
                if (path.equals("/servlet/login") || path.equals("/servlet/registration")) {
                    req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, res);
                }
                if (verifyRole(u, path)) {
                    proccessAuthorized(req, res, filterChain);
                } else {
                    proccessDenied(servletRequest, servletResponse);
                }
            }
        }
    }

    private void proccessDenied(ServletRequest servletRequest,
                                ServletResponse servletResponse)
            throws ServletException, IOException {
        servletRequest.getRequestDispatcher("/WEB-INF/views/403.jsp").
                forward(servletRequest, servletResponse);
    }

    private boolean verifyRole(User user, String path) {
        String role = protectedUrls.get(path);
        if (user.getRoles().getRole().equals(role)) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

    private void proccessUnAuthorized(HttpServletRequest request,
                                      HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    private void proccessAuthorized(ServletRequest request,
                                    ServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
