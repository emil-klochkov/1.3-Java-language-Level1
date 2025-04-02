package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class Main {
    public static void main(String[] args) {

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);


        List<Integer> secondList = new ArrayList<>();


        ListIterator<Integer> listIterator = firstList.listIterator(firstList.size()); // Start at the end
        while (listIterator.hasPrevious()) {
            secondList.add(listIterator.previous());
        }


        System.out.println("First List:");
        System.out.println(firstList);

        System.out.println("\nSecond List (reversed):");
        System.out.println(secondList);
    }
}