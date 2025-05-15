package com.filepars.csvpars.Configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig implements  WebMvcConfigurer{

    @Override
    void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedMethods("GET","POST","PUT","DELETE")
        .allowedHeaders("*")
        .allowCredentials(true)
        .allowedOrigins("http://localhost:5173")
    }

}
