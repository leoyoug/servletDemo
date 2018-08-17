package com.touch.serviceuser;

import com.touch.dbutil.Dbuerimp;
import com.touch.dbutil.Dbuser;
import com.touch.entity.Person;
import java.util.List;
import java.io.*;
public class Serviceimp implements LoginService {
    private Dbuser dbuser=new Dbuerimp();
    public boolean reg(Person p) {

        return false;
    }

    public boolean getin(String name,String password) {
        File file=new File("3.txt");
//                System.out.println(file.());
                System.out.println("这是什么么");
                System.out.println(this.getClass().getResource("/").getPath());





        return new Dbuerimp().islogin(name,password);
    }

    public List<Person> findall() {
        List<Person> list=dbuser.findallperson();
        return list;

    }
}
