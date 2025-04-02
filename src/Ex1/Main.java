package Ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();
        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        months.add(7, new Month("August"));

        System.out.println("Months in ArrayList:");
        for (Month month : months) {
            System.out.println(month);
        }

        HashSet<Month> monthSet = new HashSet<>(months);

        System.out.println("\nMonths in HashSet (no duplicates):");
        for (Month month : monthSet) {
            System.out.println(month);
        }

        System.out.println("\nIterating HashSet with an Iterator:");
        Iterator<Month> iterator = monthSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}