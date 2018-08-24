package com.touch.dbutil;

import java.sql.Connection;

public class ThreadLocalCon {
    public static Connection getlocalcon(){
        ThreadLocal t1=new ThreadLocal();
        Connection cn=DB_C3P0.getconnection();
        t1.set(cn);
        return (Connection) t1.get();
    }
}
