package com.touch.dbutil.book;

import com.touch.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface DbBook {
    public List<Book> findall() throws SQLException;

    public  List<String> findallcata() throws SQLException;

    public void insert(Book book) throws SQLException;
}
