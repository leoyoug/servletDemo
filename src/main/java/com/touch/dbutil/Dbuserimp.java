package com.touch.dbutil;

import com.touch.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dbuserimp implements Dbuser {
    public List<Person> findallperson() {
       Connection con=Dbutil.getconnection();
       String sql="select * from user";
       List list=new ArrayList();
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while (rs.next()){
                Person p=new Person();
                p.setname(rs.getString("name"));
                p.setbirthday(rs.getString("birthday"));
                p.setpassword(rs.getString("password"));
                p.setemail(rs.getString("email"));
                p.setid(rs.getInt("id"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//    根据用户名和密码查找人
    public Person findperson(String name, String password) {
        Person p=new Person();
        String sql="select * from user where name=? and password=?";
        Connection connection=Dbutil.getconnection();
        try {
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1,name);
            pre.setString(2,password);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                p.setid(Integer.parseInt(rs.getString("id")));
                p.setname(rs.getString("name"));
                p.setbirthday(rs.getString("birthday"));
                p.setpassword(rs.getString("password"));
                p.setemail(rs.getString("email"));
            }
            Dbutil.close(connection,pre,rs);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean islogin(String name, String password) {

        String sql="select * from user where name=? and password=?";
        Connection connection=Dbutil.getconnection();
        try {
            connection.setAutoCommit(false);  // 事务开始了

            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1,name);
            pre.setString(2,password);
            ResultSet rs=pre.executeQuery();
            connection.commit();  // 提交事务
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void inserperson(Person person) throws SQLException {
        String sql="INSERT INTO javaee.`user`(name,password,email,birthday) VALUES(?,?,?,?)";
        Connection con=Dbutil.getconnection();
        PreparedStatement pre=con.prepareStatement(sql);
        pre.setString(1,person.getName());
        pre.setString(2,person.getPassword());
        pre.setString(3,person.getEmail());
        pre.setString(4,person.getBirthday());
        pre.execute();
        pre.close();
        con.close();


    }

    public void updateperson(Person person) {

    }
}
