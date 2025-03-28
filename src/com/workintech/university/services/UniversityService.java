package com.workintech.university.services;

import com.workintech.university.exceptions.FacultyNotFoundException;
import com.workintech.university.models.Faculty;
import com.workintech.university.models.University;

public interface UniversityService {
    Faculty getFacultyByIdThrowException(Long id) throws FacultyNotFoundException;
    void addFaculty(University university, Faculty faculty);

}
