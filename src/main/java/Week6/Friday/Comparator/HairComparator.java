package Week6.Friday.Comparator;

import Week6.Friday.Objects.Person;
import java.util.Comparator;

public class HairComparator implements Comparator<Person> {
    @Override
    public int compare(Person hair1, Person hair2) {
        return hair1.getHair().compareTo(hair2.getHair());
    }
}
