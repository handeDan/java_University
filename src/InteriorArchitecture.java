import java.util.List;

public class InteriorArchitecture extends Department{
    private static final String NAME = "Interior Architecture";

    public InteriorArchitecture(long id, String departmentHead, Faculty faculty) {
        super(id, NAME, departmentHead, faculty);
    }

    @Override
    public List<String> lessonsToLearn() {
        return List.of("Technical Drawing", "Autocad", "Interior Designing", "Exhibition Design");
    }
}
