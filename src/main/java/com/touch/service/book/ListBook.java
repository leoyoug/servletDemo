package com.touch.service.book;

import com.touch.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface ListBook {
   public List<Book> findall() throws SQLException;
}
