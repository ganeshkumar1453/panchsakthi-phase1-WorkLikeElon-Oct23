package com.example.worklikeelon.adapter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.example.worklikeelon.adapter.ProjectTaskDetailsRestAPIAdapter;
import com.example.worklikeelon.model.IndividualProjectTaskDetails;
import com.example.worklikeelon.model.ProjectTaskDetailsPojo;
import com.example.worklikeelon.model.SortIndividualProjectTaskDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Component("projectTaskDetailsRestAPIAdapterImpl")
public class ProjectTaskDetailsRestAPIAdapterImpl implements ProjectTaskDetailsRestAPIAdapter {

    @Override
    public ProjectTaskDetailsPojo createOrUpdateProjectTaskDetails(ProjectTaskDetailsPojo projectTaskDetailsPojo)
                    throws InterruptedException, ExecutionException {
        CollectionReference collection = getFireBaseCollectionObj();
        List<ApiFuture<WriteResult>> futures = new ArrayList<>();
        List<IndividualProjectTaskDetails> individualProjectTaskDetailsList = projectTaskDetailsPojo.getIndividualProjectTaskDetailsList();
        if (null == individualProjectTaskDetailsList) {
            return null;
        }
        individualProjectTaskDetailsList.forEach(individualProjectTaskDetails -> {
            ApiFuture<WriteResult> futureIndiv = collection.document(String.valueOf(individualProjectTaskDetails.getSerialNo()))
                                                           .set(individualProjectTaskDetails);

            futures.add(futureIndiv);
        });
        return projectTaskDetailsPojo;
    }

    @Override
    public ProjectTaskDetailsPojo deleteProjectTaskDetails(List<String> serialNoListInt) {
        ProjectTaskDetailsPojo projectTaskDetailsPojo = new ProjectTaskDetailsPojo();
        CollectionReference collection = getFireBaseCollectionObj();
        if (null == serialNoListInt || serialNoListInt.isEmpty()) {
            return null;
        }
        List<IndividualProjectTaskDetails> connectionUrlDetailsList = new ArrayList<IndividualProjectTaskDetails>();
        serialNoListInt.forEach(indivSerialNo -> {
            IndividualProjectTaskDetails connectionUrlDetails = new IndividualProjectTaskDetails();
            connectionUrlDetails.setSerialNo(Integer.parseInt(indivSerialNo));
            collection.document(String.valueOf(indivSerialNo))
                      .delete()
                      .isDone();
            connectionUrlDetailsList.add(connectionUrlDetails);
        });
        projectTaskDetailsPojo.setIndividualProjectTaskDetailsList(null);
        projectTaskDetailsPojo.setStatus("Serial No's " + serialNoListInt.toString() + " is deleted sucessfully");
        return projectTaskDetailsPojo;
    }

    @Override
    public ProjectTaskDetailsPojo getProjectTaskDetail() throws InterruptedException, ExecutionException {
        ProjectTaskDetailsPojo projectTaskDetailsPojo = new ProjectTaskDetailsPojo();
        Gson gson = new GsonBuilder().create();
        CollectionReference collection = getFireBaseCollectionObj();
        ApiFuture<QuerySnapshot> apiFuture = collection.get();
        QuerySnapshot querySnapshot = apiFuture.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        List<IndividualProjectTaskDetails> IndividualProjectTaskDetailsList = new ArrayList<IndividualProjectTaskDetails>();
        for (QueryDocumentSnapshot indivDocument : documents) {
            Map<String, Object> dataFieldMap = indivDocument.getData();
            String getIndividualProjectTaskDetailsStr = gson.toJson(dataFieldMap);
            IndividualProjectTaskDetails individualProjectTaskDetails = gson.fromJson(getIndividualProjectTaskDetailsStr,
                IndividualProjectTaskDetails.class);
            IndividualProjectTaskDetailsList.add(individualProjectTaskDetails);
        }
        if (null != IndividualProjectTaskDetailsList && !IndividualProjectTaskDetailsList.isEmpty()) {
            Collections.sort(IndividualProjectTaskDetailsList, new SortIndividualProjectTaskDetails());
        }
        projectTaskDetailsPojo.setIndividualProjectTaskDetailsList(IndividualProjectTaskDetailsList);
        return projectTaskDetailsPojo;
    }

}
