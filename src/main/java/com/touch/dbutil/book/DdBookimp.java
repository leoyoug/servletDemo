package com.touch.dbutil.book;

import com.touch.dbutil.DB_C3P0;
import com.touch.entity.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DdBookimp implements DbBook {
    public List<Book> findall() throws SQLException {
        List<Book> list=new ArrayList<Book>();
        Connection con= DB_C3P0.getconnection();
        QueryRunner runner=new QueryRunner(DB_C3P0.getdatasource());
        String sql="select * from book";
       return runner.query(sql, new BeanListHandler<Book>(Book.class));
    }

    public List<String> findallcata() throws SQLException {
//        QueryRunner runner=new QueryRunner(DB_C3P0.getdatasource());
        Connection cn=DB_C3P0.getconnection();
        List<String> list=new ArrayList<String>();
        String sql="SELECT category FROM book GROUP BY category";
        PreparedStatement pre=cn.prepareStatement(sql);
        ResultSet rs=pre.executeQuery();
        while (rs.next()){
            list.add(rs.getString("category"));
        }
        return  list;
    }

    public void insert(Book book) throws SQLException {
        QueryRunner runner=new QueryRunner(DB_C3P0.getdatasource());
        String sql="INSERT INTO book(NAME,price,publication,author,img,category) VALUES(?,?,?,?,?,?)";
        runner.update(sql,book.getName(),book.getPrice(),book.getPublication(),book.getAuthor(),book.getImg(),book.getCategory());
    }
}
