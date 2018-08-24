package com.touch.servlet.book;

import com.touch.entity.Book;
import com.touch.service.book.ListBook;
import com.touch.service.book.ListBookimp;
import com.touch.service.book.ListCategory;
import com.touch.service.book.ListCategoryimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Booklist extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取所有的书籍
        ListBook listBook=new ListBookimp();
        List<Book> list= null;
        try {
            list = listBook.findall();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        获取所有的目录
        ListCategory service=new ListCategoryimp();
        List<String> cate= null;
        try {
            cate = service.findallCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(cate);
        req.setAttribute("category",cate);
        req.setAttribute("booklist",list);
        req.getRequestDispatcher("/bookstore/booklist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
