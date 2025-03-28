package com.workintech.university.models;

import java.util.List;

public class SoftwareEngineering extends Department {
    private static final String NAME = "Software Engineering";

    public SoftwareEngineering(long id, String departmentHead, Faculty faculty) {
        super(id, NAME, departmentHead, faculty);
    }

    @Override
    public List<Course> lessonsToLearn() {
        return getCourseSet()
                .stream()
                .toList(); //List.of("Java", "Effective Programming", "Algorithms", "C++");
    }
}
