package com.example.worklikeelon.adapter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.example.worklikeelon.model.UserSessionDetails;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;


public interface WorkLikeEloneRestAPIAdapter {

    default DocumentReference getFireBaseCollectionObj() {
        Firestore fireStore = FirestoreClient.getFirestore();
        CollectionReference collection = fireStore.collection("UserLoginCollection");
        return collection.document("UserDetailListDoc");
    }

    boolean validateUserSessionLogin(UserSessionDetails userSesssionDetails) throws InterruptedException, ExecutionException, TimeoutException;
}
