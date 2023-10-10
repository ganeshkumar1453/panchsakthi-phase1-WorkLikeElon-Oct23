package com.example.worklikeelon.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.worklikeelon.api.error.ApiError;
import com.example.worklikeelon.exception.ProjectTaskDetailsException;
import com.example.worklikeelon.facade.ProjectTaskDetailsFacade;


@RestController
@RequestMapping(path = "projectTaskApp")
public class ProjectTaskDetailsController {

    @Autowired
    ProjectTaskDetailsFacade projectTaskDetailsFacade;

    @GetMapping("/getProjectTaskDetails")
    public ResponseEntity<Object> getProjectTaskDetails() {
        System.out.println("################ getProjectTaskDetails Entry ####################");
        try {
            return projectTaskDetailsFacade.getProjectTaskDetails();
        } catch (InterruptedException | ExecutionException ex) {
            return buildResponseEntity((new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex)));
        }
    }

    @PostMapping("/createOrUpdateProjectTaskDetails")
    public ResponseEntity<Object> createHealthDetailsPojo(@RequestBody String projectTaskDetailsPojoStr)
                    throws InterruptedException, ExecutionException {
        try {
            return projectTaskDetailsFacade.createOrUpdateProjectTaskDetails(projectTaskDetailsPojoStr);
        } catch (ProjectTaskDetailsException ex) {
            return buildResponseEntity((new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex)));
        }
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @DeleteMapping("/deleteProjectTaskDetails/{serialNoList}")
    public ResponseEntity<Object> deleteProjectTaskDetails(@PathVariable(value = "serialNoList") String serialNoList) {
        try {
            return projectTaskDetailsFacade.deleteProjectTaskDetails(serialNoList);
        } catch (ProjectTaskDetailsException ex) {
            return buildResponseEntity((new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex)));
        }
    }

}
