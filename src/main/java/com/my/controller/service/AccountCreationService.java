package com.my.controller.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AccountCreationService {
    String creation(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
