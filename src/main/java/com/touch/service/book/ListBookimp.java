package com.touch.service.book;

import com.touch.dbutil.book.DbBook;
import com.touch.dbutil.book.DdBookimp;
import com.touch.entity.Book;

import java.sql.SQLException;
import java.util.List;

public class ListBookimp implements ListBook {
    public List<Book> findall() throws SQLException {
        DbBook db=new DdBookimp();
        return db.findall();

    }
}
