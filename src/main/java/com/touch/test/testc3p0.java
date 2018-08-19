package com.touch.test;

import com.touch.dbutil.DB_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class testc3p0 {
    public static void main(String[] args) throws SQLException {
        Connection cn=DB_C3P0.getconnection();
//        System.out.println(cn);
        String sql="select * from user";
        PreparedStatement statement=cn.prepareStatement(sql);
        ResultSet rs=statement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
    }
}
