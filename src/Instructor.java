import java.util.Collections;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Instructor implements Comparable<Instructor> {
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Boolean hasMsc;
    private Boolean hasPhd;

    private SortedSet<Course> courses;

    public Instructor(Long id, String firstName, String lastName, Double salary, Boolean hasMsc, Boolean hasPhd) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSalary(salary);
        this.setHasMsc(hasMsc);
        this.setHasPhd(hasPhd);
        this.courses = new TreeSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("Firstname null veya boş olamaz.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Lastname null veya boş olamaz.");
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getHasMsc() {
        return hasMsc;
    }

    public void setHasMsc(Boolean hasMsc) {
        this.hasMsc = hasMsc;
    }

    public Boolean getHasPhd() {
        return hasPhd;
    }

    public void setHasPhd(Boolean hasPhd) {
        this.hasPhd = hasPhd;
    }

    public SortedSet<Course> getCourses() {
        return Collections.unmodifiableSortedSet(courses);
    }

    public void addCourse(Course course) {
        /* Course c++ = new Course();
        c++.getInstuctors();
        Instructor instructor = new Instructor();
        instructor.addCourse(c++);
        c++.getInstructors(); */

        courses.add(course);
        //course.addInstructor(this);
    }

    public void removeCourse(Course course) {
        /* Course c++ = new Course();
        c++.getInstuctors();
        Instructor instructor = new Instructor();
        instructor.addCourse(c++);
        instructor.removeCourse(c++);
        c++.getInstructors(); */

        courses.remove(course);
        //course.removeInstructor(this);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Instructor instructor = (Instructor) o;
        return instructor.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "First Name : " + this.firstName +
                " Last Name : " + this.lastName +
                " Has Msc : " + this.hasMsc +
                " Has Phd : " + this.hasPhd;
    }

    @Override
    public int compareTo(Instructor o) {
        return this.firstName.compareTo(o.getFirstName());
    }
}
