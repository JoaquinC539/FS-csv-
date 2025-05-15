package com.filepars.demo.Services

import com.filepars.demo.Models.User
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.bean.HeaderColumnNameMappingStrategy
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class CsvService {
    List<User> readCsvFile(MultipartFile file) throws IOException{
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream())) ){
            HeaderColumnNameMappingStrategy<User> strategy= new HeaderColumnNameMappingStrategy<>();
            strategy.setType(User.class)
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
            .withMappingStrategy(strategy)
            .withIgnoreLeadingWhiteSpace(true)
            .withIgnoreEmptyLine(true)
            .build()
            return csvToBean.parse()
        }
    }
}
