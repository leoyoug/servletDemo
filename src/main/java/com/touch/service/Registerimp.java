package com.touch.service;

import com.touch.dbutil.Dbuser;
import com.touch.dbutil.Dbuserimp;
import com.touch.entity.Person;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Registerimp implements Register {
    private Dbuser dbuser=new Dbuserimp();
    public Map<String, String> valid(Person person) {
        Map<String,String> map=new HashMap<String, String>();
        String name=person.getName();
        String password=person.getPassword();
        if(name.equals("")){
            map.put("name","用户名不能为空");
        }else if (!name.matches("\\w{3,10}")){
            map.put("name","用户名需要3-10个字符");
        }
       if(password.equals("")){
            map.put("password","密码不能为空");
       }else if (password.matches("\\w{3,10}")){
           map.put("password","密码需在3-10个字符之间");
       }
        return map;
    }
    public void insert(Person person) throws SQLException {
        dbuser.inserperson(person);
    }
}
