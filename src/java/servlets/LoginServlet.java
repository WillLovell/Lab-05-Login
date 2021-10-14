
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session;
            session = request.getSession();
         if(request.getQueryString()!= null)
        {
            if(request.getQueryString().equals("logout"))
            {
               session.invalidate();
               session = request.getSession();
               request.setAttribute("msg", "You have logged out!");
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
           
            }
        } 
        
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");

        if(username != null && password != null)
        {           
             response.sendRedirect("home");       
        }
        else
        {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        }
        
    }

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        if(username.equals("abe") && password.equals("password") || username.equals("barb") && password.equals("password"))
        {           
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("home"); 
            
         }
        else
        {
            
            request.setAttribute("msg", "Failed authentication");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }
        
 }
        
       
   

    

