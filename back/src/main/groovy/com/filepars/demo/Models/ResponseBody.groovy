package com.filepars.demo.Models

import lombok.AllArgsConstructor
import lombok.Data

@Data
class ResponseBody {

    Boolean error
    String message
    Object body


    ResponseBody(){}
    ResponseBody(Boolean error,String message){
        this.error=error
        this.message=message


    }
    ResponseBody(Boolean error,Object body){
        this.error=error
        this.body=body
    }
    ResponseBody(Boolean error,String message,Object body){
        this.error=error
        this.message=message
        this.body=body
    }

}
