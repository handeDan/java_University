import java.util.List;

public abstract class Department {
    private Long id;
    private String name;
    private String departmentHead;
    private Faculty faculty; //bağlı olduğu fakülte

    public Department(long id, String name, String departmentHead, Faculty faculty) {
        this.setId(id);
        this.setName(name);
        this.setDepartmentHead(departmentHead);
        this.faculty = faculty;
        this.faculty.addDepartment(this);
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
}
