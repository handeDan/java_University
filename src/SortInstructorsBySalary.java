import java.util.Comparator;

public class SortInstructorsBySalary implements Comparator<Instructor> {
    @Override
    public int compare(Instructor o1, Instructor o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
