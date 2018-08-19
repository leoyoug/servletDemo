package com.touch.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DB_C3P0 {
    private static DataSource ds=null;
    static {
         ds=new ComboPooledDataSource();

    }
    public static Connection getconnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
