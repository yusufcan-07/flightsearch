package com.example.flightsearch.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {

    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // ya da hangi HTTP durum kodunu uygun görüyorsanız
    public String handleError() {
        // Özelleştirilmiş bir hata sayfasına yönlendirme yapabilirsiniz
        return "Error Handling";
    }


    public String getErrorPath() {
        return "/error";
    }
}
