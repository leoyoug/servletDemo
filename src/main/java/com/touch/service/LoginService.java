package com.touch.service;

import com.touch.entity.Person;

import java.util.List;

public interface LoginService {
    public boolean reg(Person p);
    public boolean getin(String name,String password);
    public List<Person> findall();

}
