package com.workintech.university.utils;

import com.workintech.university.models.Instructor;

import java.util.Comparator;

public class SortInstructorsBySalary implements Comparator<Instructor> { //comparator: class nesnelerini özel bir kritere göre sıralamak için kullanılır
    @Override
    public int compare(Instructor o1, Instructor o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
