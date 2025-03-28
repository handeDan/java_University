package com.workintech.university.models;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Department implements Comparable<Department> { //Comparable: class nesnelerinin sıralanabilir olmasını sağlar
    private Long id;
    private String name;
    private String departmentHead;
    private Faculty faculty; //bağlı olduğu fakülte

    private Map<Long, Course> courseMap;

    public Department(long id, String name, String departmentHead, Faculty faculty) {
        this.setId(id);
        this.setName(name);
        this.setDepartmentHead(departmentHead);
        this.faculty = faculty;
        this.faculty.addDepartment(this);
        this.courseMap = new HashMap<>();
    }

    public abstract List<Course> lessonsToLearn();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id < 0) {
            throw new IllegalArgumentException("com.workintech.university.models.Department ID 0'dan küçük olamaz.");
        }
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Department o) {
        return this.name.compareTo(o.getName()); //A'dan Z'ye sıralar. ters sıralama isteseydik: return o.getName().compareTo(this.name);
    }

    public void addCourse(Course course) {
        if(!course.getDepartment().equals(this))
            return;
        courseMap.put(course.getId(), course);
    }

    public void removeCourse(Long courseId) {
        courseMap.remove(courseId);
    }

    public Set<Course> getCourseSet() {
        return courseMap
                .values()
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department department = (Department) o;
        return department.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
