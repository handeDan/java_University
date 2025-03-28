package com.workintech.university.models;

import java.util.*;

public class Course implements Comparable<Course>{
    private Long id;
    private String name;
    private String code;
    private Double gpa;
    private Department department;

    private SortedSet<Instructor> instructors;

    public Course(Long id, String name, String code, Double gpa, Department department) {
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setGpa(gpa);
        this.setDepartment(department);
        //this.department.addCourse(this);
        this.instructors = new TreeSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        if(!instructor.getCourses().contains(this)) {
            instructor.addCourse(this);
        }
    }

    public void removeInstructor(Instructor instructor) {
        instructors.remove(instructor);
        if(!instructor.getCourses().contains(this)) {
            instructor.removeCourse(this);
        }
    }

    public Set<Instructor> getInstructors(){
        return Collections.unmodifiableSortedSet(instructors);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return course.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Name : " + this.name +
                " Code : " + this.code;
    }

    @Override
    public int compareTo(Course o) {
        return this.code.compareTo(o.getCode());
    }
}
