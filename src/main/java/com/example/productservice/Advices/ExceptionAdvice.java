package com.example.productservice.Advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "SomethingWentWrong!!!!";
    }

}
