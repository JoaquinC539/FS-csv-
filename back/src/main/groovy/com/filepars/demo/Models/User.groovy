package com.filepars.demo.Models

import com.opencsv.bean.CsvBindByName

class User {

    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Email")
    private String email
    @CsvBindByName(column = "Age")
    private Integer age;
    User(){}
    User(String name, String email,Integer age){
        this.name=name
        this.email=email
        this.age=age
    }
}
