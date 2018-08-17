package com.touch;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cklog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        添加cookie的servlet
        req.setCharacterEncoding("utf-8");
        Cookie[] ck=req.getCookies();
        String cks="";
        if(ck!=null){
//           对于已经存在的cookie
           for(Cookie cookie:ck){
               if ("ids".equals(cookie.getName())){
                   String ids=cookie.getValue();
                   String [] str=ids.split("\\&");
                   for (int x=0;x<str.length&&x<3;x++){
                         cks=cks+"&"+str[x];
                   }
               }
           }
        }
        add(req,resp,cks);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp, String cks) {
        String id=req.getParameter("id");
//        cks.replaceAll(id+"&","");
        Cookie cookie=new Cookie("ids",id+cks);
        cookie.setPath("/");
        cookie.setMaxAge(400);
        resp.addCookie(cookie);
    }
}
