package by.Messenger.controllers.web.servlets.api;


import by.Messenger.storages.entity.Message;
import by.Messenger.storages.entity.User;
import by.Messenger.services.MessageService;
import by.Messenger.services.UserService;
import by.Messenger.services.api.IMessageService;
import by.Messenger.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);


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
