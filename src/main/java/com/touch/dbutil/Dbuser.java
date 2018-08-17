package com.touch.dbutil;

import com.touch.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface Dbuser {
    public List<Person> findallperson();
    public Person findperson(String name,String password);
    public boolean islogin(String name,String password);
    public void inserperson(Person person);
    public void updateperson(Person person);
}
