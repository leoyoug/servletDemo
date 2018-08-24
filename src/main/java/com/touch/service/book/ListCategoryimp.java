package com.touch.service.book;

import com.touch.dbutil.book.DbBook;
import com.touch.dbutil.book.DdBookimp;

import java.sql.SQLException;
import java.util.List;

public class ListCategoryimp implements ListCategory {
    public List<String> findallCategory() throws SQLException {
        DbBook dbBook=new DdBookimp();
        return  dbBook.findallcata();
    }
}
