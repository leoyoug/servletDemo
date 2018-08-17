package com.touch.serviceuser;

import com.touch.entity.Person;

import java.util.Map;

public interface RegisterValidate {
    public Map<String,String> valid(Person person);
}
