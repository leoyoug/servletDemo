package com.touch.servlet.book;

import com.touch.entity.Book;
import com.touch.service.book.AddBookService;
import com.touch.service.book.AddBookServiceimp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Book book=new Book();
        try {
            BeanUtils.populate(book,req.getParameterMap());
            AddBookService service=new AddBookServiceimp();
            boolean flag=service.add(book);
            req.setAttribute("flag",flag);
            req.getRequestDispatcher("/bookstore/addbook.jsp").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
