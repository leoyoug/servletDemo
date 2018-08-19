package com.touch.service;

import com.touch.entity.Person;

import java.sql.SQLException;
import java.util.Map;

public interface Register {
    public Map<String,String> valid(Person person);
    public void insert(Person p) throws SQLException;
}
