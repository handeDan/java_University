package com.workintech.university.models;

import java.util.*;
import java.util.stream.Collectors;

public class University {

    public static final String NAME = "Workintech com.workintech.university.models.University"; //const tanımladıklarımızı büyük harfle yazarız.
    private static University instance;

    private List<Faculty> faculties;
    private Map<Long, Faculty> facultyMap;  //-> id'ye göre arama

    private University(){ //String name
        //this.name = name;
        this.faculties = new ArrayList<>();
    } //private yaptığımız için diğer class'larda "com.workintech.university.models.University university = new com.workintech.university.models.University ()" yapamayız.

    public static University getInstance() {
        if(instance == null) {
            instance = new University();
        }
        return instance;
    }
    //com.workintech.university.models.University.getIntance("Workintech com.workintech.university.models.University");
    //com.workintech.university.models.University university = com.workintech.university.models.University.getInstance();

    public void addFaculty(Faculty faculty) {
        if(faculties == null) {
            faculties = new ArrayList<>();
        }
        if(!faculties.contains(faculty)){
            faculties.add(faculty);
        }
        if(this.facultyMap == null){
            this.facultyMap=new HashMap<>();
        }
        if(!facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
        }
    }
    //com.workintech.university.models.University university = com.workintech.university.models.University.getInstance();
    //university.addFaculty(faculty)
    //university.getFaculties().add(faculty); : encapsulation'a uymuyor.


    public List<Faculty> getFaculties() {
        return faculties
                .stream()
                .collect(Collectors.toUnmodifiableList()); //okunabilir, set edileemez, değiştirilemez.
    }

    public Optional<Faculty> getFacultyById(Long id) {
        //1. yöntem:
        // for(com.workintech.university.models.Faculty faculty: faculties) {
        //  if(faculty.getId().equals(id)) {
        //    return Optional.of(faculty);
        //}
        //}

        //2. yöntem: stream api ile
        faculties.stream()
                .filter(faculty -> faculty.getId().equals(id))
                .findFirst();

        return Optional.of(null);
    }



        //3.yöntem:
        public Optional<Faculty> getFacultyByIdForAMap(Long id) {
            return Optional.ofNullable(facultyMap.get(id));
        }

        // Optional: içi boş da olabilir, için de değer de olabilir..
        /* Optional<com.workintech.university.models.Faculty> optionalFaculty =  getFacultyById(10L);
        if(optionalFaculty.isPresent()) {
            com.workintech.university.models.Faculty foundFaculty = optionalFaculty.get();
            System.out.println(optionalFaculty.get());
            System.out.println("Aranan fakülte bulundu : " + foundFaculty.getName());
        } else {
            System.out.println("Fakülte bulunamadı.");
        } */

    public Optional<Faculty> getFacultyByName(String name) {
        return faculties
                .stream()
                .filter(faculty -> faculty.getName().equalsIgnoreCase(name))
                .findFirst(); //findFirst(): stream final method
    }

    //NOTLAR :
    //List<com.workintech.university.models.Faculty> faculties; : referansa göre
    //.contains :  equals'ın override edilmesi gerekli

    //Set<com.workintech.university.models.Faculty> faculties;
    //.contains :  equals'ın ve hashCode'un override edilmesi gerekli (hashCode, equals'a göre yazılmalı)

    //
}
