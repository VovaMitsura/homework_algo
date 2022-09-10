package search;

import person.Person;
import sort.MergeSort;
import sort.PersonSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Search implements PersonSearch {

    @Override
    public int search(List<Person> peopleList) {
        PersonSort personSort = new MergeSort();
        peopleList = personSort.sort(peopleList, (p1, p2) -> {
            int total = p1.getWeight() - p2.getWeight();
            if (total == 0) {
                return p1.getHeight() - p2.getHeight();
            } else
                return total;
        }); // O(n * log(n))
        List<Integer> occurrences = occurrencesOfUsersWithEqualsWeightButDifferentHeight(peopleList); //O(n^2)
        return Collections.max(occurrences); // O(n)
    }

    private List<Integer> occurrencesOfUsersWithEqualsWeightButDifferentHeight(List<Person> peopleList) {
        int[] occurrencesOfWeight = new int[peopleList.size()];
        List<Integer> heights = new ArrayList<>();

        int currentWeight = -1;
        int maxOccurrence = 0;
        int k = 0;

        for (int i = 0; i < peopleList.size(); i++) { // c0 * n
            Person person = peopleList.get(i);  // c1 * (n-1)

            if (person.getWeight() != currentWeight) { //c2 * (n-1)
                if (currentWeight == -1) { // c3
                    currentWeight = person.getWeight(); // c4
                } else {
                    currentWeight = person.getWeight(); // c5 * (n-1)
                    k++; // c6 * (n-1)
                    maxOccurrence = 0; // c7 * (n-1)
                    heights.clear(); // c8 * (n-1)
                } //
                i--; // c9 * (n-1)
            } else if (!heights.contains(person.getHeight())) { //с10 (n-1)(n-2); -> внутрішній цикл в contains
                maxOccurrence++; // c11 * (n-2)
                heights.add(person.getHeight()); // c12 * (n-2)
                occurrencesOfWeight[k] = maxOccurrence; // c13 (n-2)
            }
        }

        return Arrays.stream(occurrencesOfWeight).boxed().collect(Collectors.toList());
    }

    //best: n * (c0 + c1 + c2 + c5+ c6+ c7 + c8 + c9) + (c3 + c4) - (c0 + c1 + c2 + c5 + c6 + c7 + c8 + c9) => O(n);
    //worst: n * (c0 + c1 + c2) - (c0 + c1 + c2 ) + (n-1)(c10 (n-2) + c11(n-2) + c13(n-2)) -> n * C - n^2 * B => O(n^2);
}
