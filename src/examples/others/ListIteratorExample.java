package examples.others;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Germany");
        list.add("France");
        list.add("Italy");
        list.add("Spain");

        ListIterator<String> listIterator = list.listIterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        listIterator.set("Испания");

        System.out.println();
        // пройти по элементам в обратном направлении
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }


    }
}
