package com.touch.servlet;

import com.touch.serviceuser.LoginService;
import com.touch.serviceuser.Serviceimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
//        获取用户的提交信息
        try {
//            设置编码
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session=req.getSession();
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String code=req.getParameter("code");
        String codes= (String) session.getAttribute("code");
        if (!codes.equals(code)){
            session.setAttribute("codewrong","验证码输入错误");
            try {
                resp.sendRedirect("login2.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            LoginService login=new Serviceimp();
            Boolean flag=login.getin(name,password);
            try{
            if (!flag){
                session.setAttribute("userwrong","wrong");
                resp.sendRedirect("login2.jsp");
            }
            else{
                session.setAttribute("role",req.getParameter("name"));
                LoginService service=new Serviceimp();
                req.setAttribute("list",service.findall());
                resp.sendRedirect("welcome.jsp");

            }}
            catch (Exception e){
                e.printStackTrace();
            }
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

    }

}
