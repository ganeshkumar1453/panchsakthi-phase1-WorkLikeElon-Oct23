package com.example.worklikeelon.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class IndividualProjectTaskDetails implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer serialNo;
    @JsonInclude(Include.NON_NULL)
    private String name;
    @JsonInclude(Include.NON_NULL)
    private String description;
    @JsonInclude(Include.NON_NULL)
    private Integer priority;
    @JsonInclude(Include.NON_NULL)
    private String status;
    @JsonInclude(Include.NON_NULL)
    private String workAndBreakTime;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkAndBreakTime() {
        return workAndBreakTime;
    }

    public void setWorkAndBreakTime(String workAndBreakTime) {
        this.workAndBreakTime = workAndBreakTime;
    }

    @Override
    public String toString() {
        return "IndividualProjectTaskDetails [serialNo=" + serialNo + ", name=" + name + ", description=" + description + ", priority=" + priority
                        + ", status=" + status + ", workAndBreakTime=" + workAndBreakTime + "]";
    }

}
