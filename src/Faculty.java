import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Faculty {
    private Long id;
    private String name;
    private LocalDate createdDate;
    private String address;
    private String phoneNumber;

    private Set<Department> departments;

    public Faculty(Long id, String name, String address, String phoneNumber) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setCreatedDate(LocalDate.now()); //şu anı alıyoruz.
        this.departments = new HashSet<>();
    }

    public Faculty(Long id, String name, String address, String phoneNumber, LocalDate createdDate) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setCreatedDate(createdDate); //şu anı alıyoruz.
        //şu şekilde de yazabilirdik:
        //this(id,name, address, phoneNumber);
        // this.cratedDate = created Date;
        this.departments = new HashSet<>();
    }

    public Long getId() {
        return id; // = return this.id;
    }

    public void setId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Faculty ID 0'dan küçük olamaz."); //runtime exception
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Department> getDepartments() {
        return departments
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Faculty faculty = (Faculty)  obj;

        return faculty.getId().equals(this.id); //&& faculty.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
