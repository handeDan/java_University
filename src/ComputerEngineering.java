import java.util.Arrays;
import java.util.List;

public class ComputerEngineering extends Department{
    private static final String NAME = "Computer Engineering";
    private List<String> programmingLanguagesShouldBeTaught;

    public ComputerEngineering(long id, String departmentHead, Faculty faculty) {
        super(id, NAME, departmentHead, faculty);
        this.programmingLanguagesShouldBeTaught = Arrays
                .asList("Java", "C#", "C++");
    }

    @Override
    //override: parent'taki methodu ezme işlemi sağlar.
    public List<String> lessonsToLearn() {
        return List.of("Introduction to Programming", "Databases", "Operating Systems");
    }
}
