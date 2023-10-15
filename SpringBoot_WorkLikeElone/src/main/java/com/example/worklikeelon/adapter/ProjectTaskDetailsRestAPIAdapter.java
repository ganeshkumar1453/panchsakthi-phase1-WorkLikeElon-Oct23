package com.example.worklikeelon.adapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.worklikeelon.model.ProjectTaskDetailsPojo;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;


public interface ProjectTaskDetailsRestAPIAdapter {

    ProjectTaskDetailsPojo createOrUpdateProjectTaskDetails(ProjectTaskDetailsPojo projectTaskDetailsPojo)
                    throws InterruptedException, ExecutionException;

    ProjectTaskDetailsPojo deleteProjectTaskDetails(List<String> serialNoListInt);

    default CollectionReference getFireBaseCollectionObj() {
        Firestore fireStore = FirestoreClient.getFirestore();
        return fireStore.collection("projectTaskDetails");
    }

    ProjectTaskDetailsPojo getProjectTaskDetail() throws InterruptedException, ExecutionException;

}
