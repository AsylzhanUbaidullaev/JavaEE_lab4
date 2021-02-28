package com.iitu.JavaEE_4.http_session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HttpFirstServlet", value = "/HttpFirstServlet")
public class HttpFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("Welcome "+n);

            HttpSession session = request.getSession();
            session.setAttribute("uname",n);

            out.print("<a href='http-servlet2'>visit</a>");

            out.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
