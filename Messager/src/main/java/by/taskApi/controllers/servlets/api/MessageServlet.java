package by.taskApi.controllers.servlets.api;


import by.taskApi.core.dto.MessageDto;
import by.taskApi.core.entity.Message;
import by.taskApi.core.entity.User;
import by.taskApi.services.MessageService;
import by.taskApi.services.UserService;
import by.taskApi.services.api.IMessageService;
import by.taskApi.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        IMessageService service = MessageService.getInstance();

        User user = (User) req.getAttribute("user"); //get user from session

        List<Message> messageList = service.get(user); // list messages for user

        req.setAttribute("messagesList", messageList);
        req.getRequestDispatcher("/ui/user/chats").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");

        IUserService serviceUser = UserService.getInstance();
        IMessageService serviceMessage = MessageService.getInstance();

        User sender = (User) req.getAttribute("user"); //get user from session
        User recipient = serviceUser.get(req.getParameter("login"));
        String text = req.getParameter("text");

        Message message = new Message(new Date(), sender, recipient, text);

        serviceMessage.validation(message);


    }
}
