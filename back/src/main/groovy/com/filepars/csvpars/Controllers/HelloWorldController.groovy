package com.filepars.csvpars.Controllers

import com.filepars.csvpars.Models.ResponseBody
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hello")
class HelloWorldController {

    @GetMapping
    ResponseEntity<ResponseBody> sayHello(){
        def resp=new ResponseBody(false,"Hello world")
        return ResponseEntity.ok(resp)
    }
}