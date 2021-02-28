package com.iitu.JavaEE_4.sessionLoginAndLogout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionLoginServlet", value = "/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link2.html").include(request, response);

        String name = request.getParameter("name");
        String password=request.getParameter("password");

        if(password.equals("admin123")){
            out.print("Welcome, " + name);
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
        }
        else{
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login2.html").include(request, response);
        }
        out.close();
    }
}
