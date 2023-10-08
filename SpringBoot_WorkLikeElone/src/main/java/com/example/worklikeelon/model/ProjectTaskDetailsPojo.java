package com.example.worklikeelon.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class ProjectTaskDetailsPojo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private String status;

    private List<IndividualProjectTaskDetails> individualProjectTaskDetailsList;

    public List<IndividualProjectTaskDetails> getIndividualProjectTaskDetailsList() {
        return individualProjectTaskDetailsList;
    }

    public void setIndividualProjectTaskDetailsList(List<IndividualProjectTaskDetails> individualProjectTaskDetailsList) {
        this.individualProjectTaskDetailsList = individualProjectTaskDetailsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
