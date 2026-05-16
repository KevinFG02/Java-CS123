package Week6.Friday.Comparator;

import Week6.Friday.Objects.Person;
import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person name1, Person name2) {
        return name1.getFullName().compareTo(name2.getFullName());
    }
}
