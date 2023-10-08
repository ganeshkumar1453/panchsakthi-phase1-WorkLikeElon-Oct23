package com.example.worklikeelon.model;

import java.util.Comparator;


public class SortIndividualProjectTaskDetails implements Comparator<IndividualProjectTaskDetails> {

    @Override
    public int compare(IndividualProjectTaskDetails connectionDetails1, IndividualProjectTaskDetails connectionDetails2) {
        return connectionDetails1.getSerialNo() - connectionDetails2.getSerialNo();
    }

}
