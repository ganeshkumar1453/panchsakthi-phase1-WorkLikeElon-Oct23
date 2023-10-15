package com.example.worklikeelon.adapter.impl;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.example.worklikeelon.adapter.WorkLikeEloneRestAPIAdapter;
import com.example.worklikeelon.model.UserSessionDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;


@Component("workLikeEloneRestAPIAdapterImpl")
public class WorkLikeEloneRestAPIAdapterImpl implements WorkLikeEloneRestAPIAdapter {

    @Override
    public boolean validateUserSessionLogin(UserSessionDetails userSesssionDetails)
                    throws InterruptedException, ExecutionException, TimeoutException {
        DocumentReference userDetailsListDoc = getFireBaseCollectionObj();
        ApiFuture<DocumentSnapshot> apiFuture = userDetailsListDoc.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Map<String, Object> data = documentSnapshot.getData();
        Map<String, String> map = (Map<String, String>) data.get("userDetailsMap");
        if (Objects.nonNull(userSesssionDetails.getPassword()) && userSesssionDetails.getPassword()
                                                                                     .equals(map.get(userSesssionDetails.getUserName()))) {
            return true;
        }
        return false;
    }

}
