package com.touch.serviceuser;

import com.touch.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class RegisterService implements RegisterValidate {

    public Map<String, String> valid(Person person) {
        Map<String,String> map=new HashMap<String, String>();
        String name=person.getName();
        String password=person.
        if(name.equals("")){
            map.put("name","用户名为空");
        }else if (!name.matches("\\w{3,10}")){
            map.put("name","用户名需要3-10个字符");
        }
       

        return null;
    }
}
