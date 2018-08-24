package com.touch.service.book;

import com.touch.dbutil.book.DbBook;
import com.touch.dbutil.book.DdBookimp;
import com.touch.entity.Book;

import java.sql.SQLException;

public class AddBookServiceimp implements AddBookService {
    public boolean add(Book book) {
        DbBook dbBook=new DdBookimp();
        try {
            dbBook.insert(book);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
