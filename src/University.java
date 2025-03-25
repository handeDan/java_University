import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class University {

    public static final String NAME = "Workintech University"; //const tanımladıklarımızı büyük harfle yazarız.
    private static University instance;

    private List<Faculty> faculties;
    private Map<Long, Faculty> facultyMap;  //-> id'ye göre arama

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

        if(!facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
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

    public Optional<Faculty> getFacultyById(Long id) {
        //1. yöntem:
        // for(Faculty faculty: faculties) {
        //  if(faculty.getId().equals(id)) {
        //    return Optional.of(faculty);
        //}
        //}

        //2. yöntem: stream api ile
        faculties.stream()
                .filter(faculty -> faculty.getId().equals(id))
                .findFirst();

        return Optional.of(null);
    }

    public Faculty getFacultyByIdThrowException(Long id) throws FacultyNotFoundException{
        Optional<Faculty> optionalFaculty =  faculties
                .stream()
                .filter(faculty -> faculty.getId().equals(id))
                .findFirst();

         if(optionalFaculty.isPresent()) {
            return optionalFaculty.get();
        } else {
             throw new FacultyNotFoundException(id + "id'li fakülte bulunamadı.");
        }
    }

        //3.yöntem:
        public Optional<Faculty> getFacultyByIdForAMap(Long id) {
            return Optional.ofNullable(facultyMap.get(id));
        }

        // Optional: içi boş da olabilir, için de değer de olabilir..
        /* Optional<Faculty> optionalFaculty =  getFacultyById(10L);
        if(optionalFaculty.isPresent()) {
            Faculty foundFaculty = optionalFaculty.get();
            System.out.println(optionalFaculty.get());
            System.out.println("Aranan fakülte bulundu : " + foundFaculty.getName());
        } else {
            System.out.println("Fakülte bulunamadı.");
        } */

    public Optional<Faculty> getFacultyByName(String name) {
        return faculties
                .stream()
                .filter(faculty -> faculty.getName().equalsIgnoreCase(name))
                .findFirst(); //findFirst(): stream final method
    }

}
