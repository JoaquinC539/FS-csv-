package com.filepars.demo.Models

import com.opencsv.bean.CsvBindByName
import lombok.Data


class User {

    @CsvBindByName(column = "Name")
    String name
    @CsvBindByName(column = "Email")
     String email
    @CsvBindByName(column = "Age")
     Integer age
    /*User(){}
    User(String name, String email,Integer age){
        this.name=name
        this.email=email
        this.age=age
    } */

}
