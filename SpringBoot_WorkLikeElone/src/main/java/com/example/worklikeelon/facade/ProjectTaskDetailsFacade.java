package com.example.worklikeelon.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.worklikeelon.adapter.ProjectTaskDetailsRestAPIAdapter;
import com.example.worklikeelon.exception.ProjectTaskDetailsException;
import com.example.worklikeelon.model.IndividualProjectTaskDetails;
import com.example.worklikeelon.model.ProjectTaskDetailsPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Service
public class ProjectTaskDetailsFacade {

    @Qualifier("projectTaskDetailsRestAPIAdapterImpl")
    @Autowired
    ProjectTaskDetailsRestAPIAdapter projectTaskDetailsRestAPIAdapter;

    public ResponseEntity<Object> createOrUpdateProjectTaskDetails(String data) throws ProjectTaskDetailsException {
        Gson gson = new GsonBuilder().create();
        System.out.println("data --> " + data);
        ProjectTaskDetailsPojo projectTaskDetailsPojo = gson.fromJson(data, ProjectTaskDetailsPojo.class);
        System.out.println("projectTaskDetailsPojo --> " + projectTaskDetailsPojo);
        if (Objects.isNull(projectTaskDetailsPojo)) {
            throw new ProjectTaskDetailsException("ProjectTaskDetails is empty or invalid json request");
        }
        List<IndividualProjectTaskDetails> individualProjectTaskDetailsList = projectTaskDetailsPojo.getIndividualProjectTaskDetailsList();
        if (null == individualProjectTaskDetailsList || individualProjectTaskDetailsList.isEmpty()) {
            throw new ProjectTaskDetailsException("ProjectTaskDetails is empty or invalid json request");
        }
        try {
            projectTaskDetailsPojo = projectTaskDetailsRestAPIAdapter.createOrUpdateProjectTaskDetails(projectTaskDetailsPojo);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (null == projectTaskDetailsPojo) {
            return ResponseEntity.notFound()
                                 .build();
        }
        return ResponseEntity.ok(projectTaskDetailsPojo);
    }

    public ResponseEntity<Object> deleteProjectTaskDetails(String serialNoListStr) throws ProjectTaskDetailsException {
        if (null == serialNoListStr || serialNoListStr.isEmpty()) {
            throw new ProjectTaskDetailsException("Serial Id List is empty or invalid json request");
        }
        String[] split = serialNoListStr.split(",");
        List<String> serialNoList = new ArrayList<String>(Arrays.asList(split));
        ProjectTaskDetailsPojo healthCheckPojo = projectTaskDetailsRestAPIAdapter.deleteProjectTaskDetails(serialNoList);
        if (null == healthCheckPojo) {
            return ResponseEntity.notFound()
                                 .build();
        }
        return ResponseEntity.ok(healthCheckPojo);
    }

    public ResponseEntity<Object> getProjectTaskDetails() throws InterruptedException, ExecutionException {
        ProjectTaskDetailsPojo projectTaskDetailsPojo = projectTaskDetailsRestAPIAdapter.getProjectTaskDetail();
        if (null == projectTaskDetailsPojo) {
            return ResponseEntity.notFound()
                                 .build();
        }
        return ResponseEntity.ok(projectTaskDetailsPojo);
    }

}
