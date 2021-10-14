package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
       String username = (String)session.getAttribute("username");
       
       User user = new User();
       user.setUsername(username);
       request.setAttribute("name", user.getUsername());
       
       if(session.getAttribute("username") != null)
       {
       getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);       
       }
       else
       {
            request.setAttribute("msg", "You must login first.");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          return;
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
}
}
