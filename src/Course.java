public class Course {
    private Long id;
    private String name;
    private String code;
    private Double gpa;
    private Department department;

    public Course(Long id, String name, String code, Double gpa, Department department) {
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setGpa(gpa);
        this.setDepartment(department);
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
}
