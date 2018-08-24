package com.touch.service.book;

import java.sql.SQLException;
import java.util.List;

public interface ListCategory {
    List<String> findallCategory() throws SQLException;
}
