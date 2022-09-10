package sort;

import person.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements PersonSort {
    @Override
    public List<Person> sort(List<Person> peopleList, Comparator<Person> personComparator) {
        Person[] people = peopleList.toArray(Person[]::new);
        mergeSort(0, people.length - 1, people, personComparator);
        return Arrays.asList(people);
    }

    private static void mergeSort(int begin, int end, Person[] people, Comparator<Person> personComparator) {
        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            mergeSort(begin, mid, people, personComparator);
            mergeSort(mid + 1, end, people, personComparator);
            merge(begin, mid, end, people, personComparator); //log2(n) * n
        }
    }

    private static void merge(int begin, int mid, int end, Person[] people, Comparator<Person> personComparator) {
        int n1 = mid - begin + 1; //c
        int n2 = end - mid;

        Person[] left = new Person[n1];
        Person[] right = new Person[n2];


        for (int i = 0; i < n1; i++) {
            left[i] = people[begin + i];
        }

        for (int i = 0; (i) < n2; i++) {
            right[i] = people[mid + 1 + i];
        }

        int k = begin;
        int i = 0;
        int j = 0;

        for (int ind = 0; ind < n1 + n2; ind++) {
            if (i < n1 && j < n2) {
                if (personComparator.compare(left[i], right[j]) <= 0) {
                    people[k++] = left[i++];
                } else {
                    people[k++] = right[j++];
                }
            } else if (i < n1) {
                people[k++] = left[i++];
            } else if (j < n2) {
                people[k++] = right[j++];
            }
        }
    }
}
