package com.workintech.university.models;

public class BscInstructor extends Instructor implements BscRole {

    public BscInstructor(Long id, String firstName, String lastName, Double salary, Boolean hasMsc, Boolean hasPhd) {
        super(id, firstName, lastName, salary, hasMsc, hasPhd);
    }

    @Override
    public void presentLesson() {

    }

    @Override
    public void takeExam() {

    }
}
