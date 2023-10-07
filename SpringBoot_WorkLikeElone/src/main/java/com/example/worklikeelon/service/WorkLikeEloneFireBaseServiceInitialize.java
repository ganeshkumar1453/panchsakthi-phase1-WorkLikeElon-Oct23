package com.example.worklikeelon.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@Service
public class WorkLikeEloneFireBaseServiceInitialize {

    @PostConstruct
    private void initialize() throws IOException {
        InputStream serviceAccount = WorkLikeEloneFireBaseServiceInitialize.class.getResourceAsStream("/path/to/serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                                                               .setDatabaseUrl(
                                                                   "https://worklikeelon-e47cd-default-rtdb.asia-southeast1.firebasedatabase.app")
                                                               .build();
        FirebaseApp.initializeApp(options);
    }

}
