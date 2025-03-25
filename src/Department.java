import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Department {
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

    public abstract List<String> lessonsToLearn();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id < 0) {
            throw new IllegalArgumentException("Department ID 0'dan küçük olamaz.");
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

    public void addCourse(Course course) {
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
}
