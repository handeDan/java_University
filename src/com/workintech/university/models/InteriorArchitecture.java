package com.workintech.university.models;

import java.util.List;

public class InteriorArchitecture extends Department {
    private static final String NAME = "Interior com.workintech.university.models.Architecture";

    public InteriorArchitecture(long id, String departmentHead, Faculty faculty) {
        super(id, NAME, departmentHead, faculty);
    }

    @Override
    public List<Course> lessonsToLearn() {
        return getCourseSet()
                .stream()
                .toList(); // List.of("Technical Drawing", "Autocad", "Interior Designing", "Exhibition Design");
    }
}
