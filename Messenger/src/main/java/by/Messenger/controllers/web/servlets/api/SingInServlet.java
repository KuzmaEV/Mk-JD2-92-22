package by.Messenger.controllers.web.servlets.api;


import by.Messenger.storages.entity.User;
import by.Messenger.services.UserService;
import by.Messenger.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingInServlet", urlPatterns = "/api/login")
public class SingInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");

        IUserService service = UserService.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");


        try {
            User user = service.validation(login, password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/").forward(req, resp);
        }








    }
}
