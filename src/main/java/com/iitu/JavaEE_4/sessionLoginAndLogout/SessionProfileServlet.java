package com.iitu.JavaEE_4.sessionLoginAndLogout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionProfileServlet", value = "/SessionProfileServlet")
public class SessionProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link2.html").include(request, response);

        HttpSession session = request.getSession(false);
        if(session != null){
            String name = (String)session.getAttribute("name");

            out.print("Hello, " + name + " Welcome to Profile");
        }
        else{
            out.print("Please login first");
            request.getRequestDispatcher("login2.html").include(request, response);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
