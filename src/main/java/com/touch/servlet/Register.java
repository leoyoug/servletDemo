package com.touch.servlet;

import com.touch.entity.Person;
import com.touch.service.Registerimp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person=new Person();
        com.touch.service.Register register=new Registerimp();
        try {
//           将用户存入person类
            BeanUtils.populate(person,req.getParameterMap());
//            使用验证类来验证person是否合法
            Map<String,String> map=register.valid(person);
            if (map.size()!=0){
//                将map传入request中
                req.setAttribute("map",map);
                req.getRequestDispatcher("register.jsp").forward(req,resp);
                return;
            }
            register.insert(person);
            req.setAttribute("success","yes");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            req.setAttribute("success","no");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
