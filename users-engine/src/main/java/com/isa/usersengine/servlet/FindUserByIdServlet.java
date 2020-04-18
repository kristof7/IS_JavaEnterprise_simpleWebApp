package com.isa.usersengine.servlet;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @Inject
    private UserService userService;

    private static final Logger logger = Logger.getLogger(FindUserByIdServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User user = userService.findById(Long.parseLong(idParam));
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<body>");

        if (user != null) {

            printWriter.println("ID: " + user.getId() + "<br>");
            printWriter.println("Name: " + user.getName() + "<br>");
            printWriter.println("Login: " + user.getLogin() + "<br>");
            printWriter.println("Age: " + user.getAge());

        } else {
            printWriter.println("User has not been found!");
        }

        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}