package com.example.worklikeelon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.worklikeelon.adapter.WorkLikeEloneRestAPIAdapter;
import com.example.worklikeelon.model.UserSessionDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Service
public class UserSessionService {

    @Qualifier("workLikeEloneRestAPIAdapterImpl")
    @Autowired
    WorkLikeEloneRestAPIAdapter workLikeEloneRestAPIAdapter;

    public ResponseEntity<Object> validateUserSessionDetails(String data) {
        try {
            Gson gson = new GsonBuilder().create();
            UserSessionDetails userSessionDetails = gson.fromJson(data, UserSessionDetails.class);
            return ResponseEntity.ok(new UserSessionDetails(workLikeEloneRestAPIAdapter.validateUserSessionLogin(userSessionDetails)));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                                 .body(e.getMessage());
        }
    }
}
