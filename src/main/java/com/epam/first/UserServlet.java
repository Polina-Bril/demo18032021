package com.epam.first;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "userServlet", urlPatterns = "/userservlet")
public class UserServlet extends HttpServlet {
    public static Logger logger = LogManager.getLogger();
    public void init(){
        logger.log(Level.INFO, "from init method in userServlet");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
        logger.log(Level.INFO, "from doGet method in userServlet");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hello, Admin!" + "</h1>");
        out.println("<html><body>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "from doPost method in userSevlet");
        String numStr = req.getParameter("number");
        int num = Integer.parseInt(numStr);
        num*=2;
        req.setAttribute("numResult", num);

        List<Message> listik = List.of(new Message(45, "Hello"), new Message(33, "Bye"));
        req.setAttribute("list", listik);
        List<User> list = List.of(new User(45, "Hello", "Nigga", Role.USER, "list@load.com", "+375447777777", 4.3), new User(41, "Hola", "Youooo", Role.ADMIN, "appa@load.com", "+375447747777", 4.9));
        req.setAttribute("lst", list);

        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }

 public void destroy(){
     logger.log(Level.INFO, "from destroy method in userSevlet");
    }
}
