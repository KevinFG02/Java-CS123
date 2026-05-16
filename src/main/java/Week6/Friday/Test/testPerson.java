package Week6.Friday.Test;

import Week6.Friday.Comparator.HairComparator;
import Week6.Friday.Comparator.NameComparator;
import Week6.Friday.Objects.Person;

import java.util.Arrays;

public class testPerson {
    public static void main(String[] args){
        Person[] comparePerson = {
                new Person("Jimothy", "Brown", 86),
                new Person("Tommy", "Black", 85),
                new Person("Hammel", "Blond", 82),
                new Person("Joe", "Black", 80)
        };

        //System.out.println(Arrays.toString(comparePerson));
        //Arrays.sort(comparePerson);
        //System.out.println(Arrays.toString(comparePerson));

        String sortType = "hair";

        System.out.println(Arrays.toString(comparePerson));

        if(sortType.equals("hair")){
            Arrays.sort(comparePerson, new HairComparator());
        } else if(sortType.equals("name")){
            Arrays.sort(comparePerson, new NameComparator());
        }
        System.out.println(Arrays.toString(comparePerson));
    }
}
