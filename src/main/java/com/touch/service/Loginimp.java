package com.touch.service;

import com.touch.dbutil.Dbuserimp;
import com.touch.dbutil.Dbuser;
import com.touch.entity.Person;
import java.util.List;
import java.io.*;
public class Loginimp implements LoginService {
    private Dbuser dbuser=new Dbuserimp();
    public boolean reg(Person p) {

        return false;
    }

    public boolean getin(String name,String password) {
        File file=new File("3.txt");
//                System.out.println(file.());
                System.out.println("这是什么么");
                System.out.println(this.getClass().getResource("/").getPath());





        return new Dbuserimp().islogin(name,password);
    }

    public List<Person> findall() {
        List<Person> list=dbuser.findallperson();
        return list;

    }
}
