import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {

    public static final String NAME = "Workintech University"; //const tanımladıklarımızı büyük harfle yazarız.
    private static University instance;

    private List<Faculty> faculties;

    private University(){ //String name
        //this.name = name;
        this.faculties = new ArrayList<>();
    } //private yaptığımız için diğer class'larda "University university = new University ()" yapamayız.

    public static University getInstance() {
        if(instance == null) {
            instance = new University();
        }
        return instance;
    }
    //University.getIntance("Workintech University");
    //University university = University.getInstance();

    public void addFaculty(Faculty faculty) {
        if(faculties == null) {
            faculties = new ArrayList<>();
        }
        if(!faculties.contains(faculty)){
            faculties.add(faculty);
        }
    }
    //University university = University.getInstance();
    //university.addFaculty(faculty)
    //university.getFaculties().add(faculty); : encapsulation'a uymuyor.


    public List<Faculty> getFaculties() {
        return faculties
                .stream()
                .collect(Collectors.toUnmodifiableList()); //okunabilir, set edileemez, değiştirilemez.
    }


}
