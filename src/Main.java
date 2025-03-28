public class Main {
    public static void main(String[] args) {
        //şunu yapamayız: University university = new University();
        University university = University.getInstance();

        Faculty engineeringFaculty = new Faculty(1L, "Engineering", "Istanbul", "+02120005050");
        Faculty architectureFaculty = new Faculty(2L, "Architecture", "Izmir", "+02120006060");

        Department softwareEnginnering = new SoftwareEngineering(1L, "Software Engineering",  engineeringFaculty);
        Department computerEnginnering = new ComputerEngineering(2L, "Computer Engineering",  engineeringFaculty);

        Department architecture = new Architecture(3L, "Architecture",  architectureFaculty);
        Department interiorArchitecture = new InteriorArchitecture(3L, "Interior Architecture", architectureFaculty);

        Course planlama = new Course(1L, "Planlama", "SB101", 5.8, architecture);
        architecture.addCourse(planlama);

        university.addFaculty(engineeringFaculty);
        university.addFaculty(architectureFaculty);
        //engineeringFaculty.addDepartment(softwareEnginnering);

        Course introductionToJava = new Course(1L, "introduction to Java", "CS101", 8.0, softwareEnginnering);
        Instructor instructor = new Instructor(1L, "Hande", "Dan", 75000.0, false, false);

        introductionToJava.addInstructor(instructor);

        for(Course course: instructor.getCourses()) {
            System.out.println(course);
        }


        System.out.println("University : " + University.NAME);

        for(Faculty faculty: university.getFaculties()){
            System.out.println("Faculty : " + faculty.getName());

            for(Department department: faculty.getDepartments()) {
                System.out.println("        Department : " + department.getName());
                System.out.println("              Lessons to Learn : " + department.lessonsToLearn());

                for(Course course : department.getCourseSet()) {
                    System.out.println("                    Course : " + course);

                }
            }
        }

    }
}