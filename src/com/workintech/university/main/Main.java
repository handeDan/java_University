package com.workintech.university.main;

import com.workintech.university.models.*;

public class Main {
    public static void main(String[] args) {
        //şunu yapamayız: com.workintech.university.models.University university = new com.workintech.university.models.University();
        University university = University.getInstance();

        Faculty engineeringFaculty = new Faculty(1L, "Engineering", "Istanbul", "+02120005050");
        Faculty architectureFaculty = new Faculty(2L, "com.workintech.university.models.Architecture", "Izmir", "+02120006060");

        Department softwareEnginnering = new SoftwareEngineering(1L, "Software Engineering",  engineeringFaculty);
        Department computerEnginnering = new ComputerEngineering(2L, "Computer Engineering",  engineeringFaculty);

        Department architecture = new Architecture(3L, "com.workintech.university.models.Architecture",  architectureFaculty);
        Department interiorArchitecture = new InteriorArchitecture(3L, "Interior com.workintech.university.models.Architecture", architectureFaculty);

        Course planlama = new Course(1L, "Planlama", "SB101", 5.8, architecture);
        architecture.addCourse(planlama);

        university.addFaculty(engineeringFaculty);
        university.addFaculty(architectureFaculty);
        //engineeringFaculty.addDepartment(softwareEnginnering);

        Course introductionToJava = new Course(1L, "introduction to Java", "CS101", 8.0, softwareEnginnering);

        Instructor mscInstructor = new MscInstructor(1L, "Hande", "Dan", 75000.0, true, false);
        Instructor bscInstructor = new BscInstructor(1L, "Hakan", "Kuru", 75000.0, false, false);

        introductionToJava.addInstructor(mscInstructor);
        mscInstructor.addCourse(introductionToJava);

        introductionToJava.addInstructor(bscInstructor);
        bscInstructor.addCourse(introductionToJava);

        for(Course course: mscInstructor.getCourses()) {
            System.out.println(course);
        }


        System.out.println("com.workintech.university.models.University : " + University.NAME);

        for(Faculty faculty: university.getFaculties()){
            System.out.println("com.workintech.university.models.Faculty : " + faculty.getName());

            for(Department department: faculty.getDepartments()) {
                System.out.println("        com.workintech.university.models.Department : " + department.getName());
                // System.out.println("              Lessons to Learn : " + department.lessonsToLearn());

                for(Course course : department.getCourseSet()) {
                    System.out.println("         com.workintech.university.models.Course : " + course);

                }
            }
        }

    }

    /*NOTLAR:
    models: üzerinde veri tuttuğumuz ama çok fazla işlem yapmadığımız class'lardır.
    services: models'i kullanıp bunlar üzerinde işlem yaptığımız class'lardır. (bussiness logic işlemi)
        **her modelin genelde service class'ı olur.
    utils: yardımcı methodların olduğu class'lardır.
        **validations gibi
    exceptions: exceptions'ları tutarız.
    repository/entity: veritabanı gibi çalışır, verileri tutar.
        **spring boot'ta entity olarak geçer.
            **service'in içinde repository'yi kullanır.
                **repository içerisinde models'i kullanır.
    console / main: application'ın başladığı, Main class'ın içinde olduğu yer.
     */
}