package com.touch.dbutil;

import com.touch.entity.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Testdb {
    public static void main(String[] args) throws SQLException {
        dotest4();
    }
    public static void dotest(){
        Dbuserimp dbuserimp =new Dbuserimp();
        List<Person>list= dbuserimp.findallperson();
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void dotest2() throws SQLException {
      Connection connection= Dbutil.getconnection();
      connection.close();
    }
    public static void dotest3(){
        Dbuserimp imp=new Dbuserimp();
        Person p=imp.findperson("yang","123");
        System.out.println(p);
    }
    public static void dotest4(){
        Dbuserimp dbuserimp =new Dbuserimp();
        Boolean flag= dbuserimp.islogin("yang","1212131");
        System.out.println(flag);
    }
}
