import person.Person;
import search.PersonSearch;
import search.Search;
import sort.MergeSort;
import sort.PersonSort;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        /*Task1*/
        System.out.println("\nSorted by age:\n");
        PersonSort personSort = new MergeSort();
        List<Person> sortedByAge = personSort.sort(initialList, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(sortedByAge);

        /*Task2*/
        System.out.println("\nSorted by weight:\n");
        List<Person> sortedByWeight = personSort.sort(initialList, (p1, p2) -> p1.getWeight() - p2.getWeight());
        System.out.println(sortedByWeight);

        System.out.println("\nSorted by height:\n");
        List<Person> sortedByHeight = personSort.sort(initialList, (p1, p2) -> p1.getHeight() - p2.getHeight());
        System.out.println(sortedByHeight);

        /*Task3*/
        PersonSearch searchByWeightAndHeight = new Search();
        int maxCountOfUsersWithEqualWeightButDifferentHeight = searchByWeightAndHeight.search(initialList);
        System.out.println("\nMax count of persons with equal weight but different height: " + maxCountOfUsersWithEqualWeightButDifferentHeight);
    }

    /*
     * Додаткове питання: "У завданні 1 чи можна забезпечити лінійну складність алгоритму по часу?"
     * В теорії доведено, що для списку елементів з заданим порядком  порівнянням найменшою часовою
     * складністю є O(n*log(n)).
     * Алгоритми без порівняння, наприклад сортування підрахунком має часову складність O(n + k), де к
     * різниця між більшим та найменшим елементом, але також він потребує додаткової пам'яті k. Перетворивши
     * вхідні дані, і враховуючи, що різниця між роками не має бути великою(якщо дані валідні) порівняно з розміром масиву,
     * можна використати цей алгоритми
     * */

    private static List<Person> initialList = List.of(
            new Person(180, 90, 10), new Person(170, 90, 1), new Person(190, 90, 21),
            new Person(180, 90, 20), new Person(170, 90, 2), new Person(190, 90, 2),
            new Person(180, 90, 30), new Person(170, 15, 3), new Person(190, 90, 20),
            new Person(180, 90, 40), new Person(170, 15, 4), new Person(190, 90, 12),
            new Person(180, 10, 50), new Person(170, 15, 5), new Person(190, 90, 22),
            new Person(180, 10, 60), new Person(170, 15, 6), new Person(190, 90, 32),
            new Person(180, 10, 70), new Person(170, 15, 7), new Person(190, 90, 42),
            new Person(180, 10, 80), new Person(170, 15, 8), new Person(190, 90, 52),
            new Person(180, 10, 90), new Person(170, 90, 9), new Person(190, 90, 62),
            new Person(180, 10, 100), new Person(170, 90, 10), new Person(190, 2, 72),
            new Person(180, 10, 120), new Person(170, 90, 11), new Person(190, 2, 82),
            new Person(180, 10, 130), new Person(170, 90, 12), new Person(190, 2, 92),
            new Person(180, 90, 140), new Person(170, 90, 13), new Person(190, 2, 102),
            new Person(180, 90, 150), new Person(170, 90, 14), new Person(190, 2, 112),
            new Person(180, 50, 160), new Person(170, 30, 15), new Person(190, 2, 122),
            new Person(180, 50, 170), new Person(170, 30, 16), new Person(190, 2, 132),
            new Person(180, 50, 180), new Person(170, 30, 17), new Person(190, 2, 142),
            new Person(180, 50, 190), new Person(170, 30, 18), new Person(180, 2, 152),
            new Person(180, 50, 200), new Person(170, 30, 19), new Person(190, 90, 162),
            new Person(180, 50, 210), new Person(170, 30, 20), new Person(190, 90, 172),
            new Person(180, 50, 220), new Person(170, 30, 21), new Person(190, 90, 182),
            new Person(180, 50, 230), new Person(170, 30, 22), new Person(190, 90, 192),
            new Person(180, 90, 240), new Person(170, 30, 23), new Person(190, 90, 202),
            new Person(180, 90, 250), new Person(170, 30, 24), new Person(190, 90, 212),
            new Person(180, 90, 260), new Person(170, 30, 25), new Person(190, 90, 222),
            new Person(180, 90, 270), new Person(170, 90, 26), new Person(190, 90, 232),
            new Person(180, 90, 280), new Person(170, 90, 27), new Person(190, 90, 242),
            new Person(180, 80, 290), new Person(170, 90, 28), new Person(190, 90, 252),
            new Person(180, 80, 300), new Person(170, 90, 29), new Person(190, 90, 262),
            new Person(180, 80, 310), new Person(170, 90, 30), new Person(190, 90, 272),
            new Person(180, 80, 320), new Person(170, 70, 31), new Person(190, 60, 282),
            new Person(180, 80, 330), new Person(170, 70, 32), new Person(190, 60, 292),
            new Person(180, 80, 340), new Person(170, 70, 33), new Person(190, 60, 302),
            new Person(180, 80, 350), new Person(179, 70, 34), new Person(190, 60, 312),
            new Person(180, 80, 360), new Person(170, 70, 35), new Person(190, 60, 322),
            new Person(190, 80, 370), new Person(140, 70, 36), new Person(190, 60, 332),
            new Person(180, 80, 380), new Person(170, 70, 37), new Person(120, 60, 342),
            new Person(180, 80, 390), new Person(171, 70, 38), new Person(190, 60, 352),
            new Person(180, 80, 400), new Person(170, 70, 39), new Person(190, 60, 362),
            new Person(170, 80, 410), new Person(160, 70, 40), new Person(191, 60, 372),
            new Person(180, 80, 420), new Person(172, 70, 41), new Person(190, 60, 382),
            new Person(180, 80, 430), new Person(173, 70, 42), new Person(190, 60, 392),
            new Person(180, 80, 440), new Person(143, 70, 43), new Person(190, 60, 402));
}
