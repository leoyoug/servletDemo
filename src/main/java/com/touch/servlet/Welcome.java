package com.touch.servlet;

import com.touch.service.LoginService;
import com.touch.service.Loginimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Welcome extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session=req.getSession();
        LoginService service=new Loginimp();
        String s= (String) session.getAttribute("role");
        if(s!=null){
            req.setAttribute("list",service.findall());
        }
        try {
            req.setAttribute("ok",new Object());
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
