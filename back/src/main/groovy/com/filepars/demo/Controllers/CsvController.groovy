package com.filepars.demo.Controllers

import com.filepars.demo.Models.ResponseBody
import com.filepars.demo.Models.User
import com.filepars.demo.Services.CsvService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/csv")
class CsvController {

    private final  CsvService csvService

     CsvController(CsvService csvService1){
        this.csvService=csvService1
    }

    @PostMapping
    public ResponseEntity<ResponseBody> uploadCsvFile( @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            def rpresp=new ResponseBody(true,"Please select a CSV to upload")
            return ResponseEntity.badRequest().body(rpresp)
        }
        if(!"text/csv".equals(file.getContentType()) && !file.getOriginalFilename().endsWith(".csv")){
            def rpresp=new ResponseBody(true,"Only CSV files are allowed")
            return ResponseEntity.badRequest().body(rpresp)
        }
        try {
            List<User> csvData=csvService.readCsvFile(file)
            def rpresp=new ResponseBody(true,csvData)
            return ResponseEntity.ok().body(rpresp)
        }catch (Exception ex) {
            def rpresp= new ResponseBody(true,"Error processing CSV file: "+ex.getMessage())
            return ResponseEntity.internalServerError().body(rpresp)
        }
    }
}
