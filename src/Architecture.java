import java.util.List;

public class Architecture extends Department{
    private static final String NAME = "Architecture";

    public Architecture(long id, String departmentHead, Faculty faculty) {
        super(id, NAME, departmentHead, faculty);
    }

    @Override
    public List<Course> lessonsToLearn() {
        return getCourseSet()
                .stream()
                .toList(); //List.of("Technical Drawing", "Autocad", "City Planning");
    }
}
