package com.digis01.PokeApiClient.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public String forbidden() {
        return "redirect:/error-view?code=403";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound() {
        return "redirect:/error-view?code=404";
    }

    @ExceptionHandler(Exception.class)
    public String generalError() {
        return "redirect:/error-view?code=500";
    }
}
