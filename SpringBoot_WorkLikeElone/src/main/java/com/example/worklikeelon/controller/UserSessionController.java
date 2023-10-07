package com.example.worklikeelon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.worklikeelon.service.UserSessionService;


@RestController
public class UserSessionController {
    @Autowired
    private UserSessionService userSessionService;

    @PostMapping(value = "/validateUser")
    public ResponseEntity<Object> validateUserSession(@RequestBody String userSessionDetails) {
        return userSessionService.validateUserSessionDetails(userSessionDetails);
    }

}
