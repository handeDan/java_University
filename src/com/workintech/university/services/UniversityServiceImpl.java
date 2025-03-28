package com.workintech.university.services;

import com.workintech.university.exceptions.FacultyNotFoundException;
import com.workintech.university.models.Faculty;
import com.workintech.university.models.University;
import com.workintech.university.repository.UniversityRepository;

import java.util.Optional;

public class UniversityServiceImpl implements UniversityService{
    private UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @Override
    public Faculty getFacultyByIdThrowException(University university, Long id) throws FacultyNotFoundException {
        Optional<Faculty> optionalFaculty =  university
                .getFaculties()
                .stream()
                .filter(faculty -> faculty.getId().equals(id))
                .findFirst();

        if(optionalFaculty.isPresent()) {
            return optionalFaculty.get();
        } else {
            throw new FacultyNotFoundException(id + "id'li fakülte bulunamadı.");
        }
    }

    @Override
    public void addFaculty(University university, Faculty faculty) {

    }
}
