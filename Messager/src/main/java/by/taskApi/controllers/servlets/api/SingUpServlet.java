package by.taskApi.controllers.servlets.api;


import by.taskApi.core.dto.RegistrationDto;
import by.taskApi.services.UserService;
import by.taskApi.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "SingUpServlet", urlPatterns = "/api/user")
public class SingUpServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");

        IUserService service = UserService.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");

//        try {
//        dateOfBirth =  format.parse(req.getParameter("dateOfBirth"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

            service.addUser(new RegistrationDto(login, password, name,dateOfBirth));
        req.getRequestDispatcher("/").forward(req, resp);

    }

    }

