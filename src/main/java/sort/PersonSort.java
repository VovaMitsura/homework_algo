package sort;

import person.Person;

import java.util.Comparator;
import java.util.List;

public interface PersonSort {
    List<Person> sort(List<Person> personList, Comparator<Person> personComparator);
}
