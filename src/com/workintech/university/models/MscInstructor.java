package com.workintech.university.models;

public class MscInstructor extends Instructor implements MscRole {
    public MscInstructor(Long id, String firstName, String lastName, Double salary, Boolean hasMsc, Boolean hasPhd) {
        super(id, firstName, lastName, salary, hasMsc, hasPhd);
    }

    @Override
    public void makeALab() {

    }

    @Override
    public void teachToWriteAcademicPaper() {

    }

    @Override
    public void presentLesson() {

    }

    @Override
    public void takeExam() {

    }
}
