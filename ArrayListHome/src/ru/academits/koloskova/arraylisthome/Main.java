package ru.academits.koloskova.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        try (Scanner readFile = new Scanner(new FileInputStream("arrayListHome.txt"))) {
            while (readFile.hasNextLine()) {
                stringList.add(readFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        System.out.println("Task №1: " + stringList);

        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (Iterator<Integer> i = integerList1.iterator(); i.hasNext(); ) {
            Integer number = i.next();
            if (number % 2 == 0) {
                i.remove();
            }
        }
        integerList1.removeIf(number -> number % 2 == 0);

        System.out.println("Task №2: " + integerList1);

        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        List<Integer> integerList3 = new ArrayList<>();

        for (Integer number : integerList2) {
            if (integerList3.contains(number)) {
                continue;
            }
            integerList3.add(number);
        }

        System.out.println("Task №3: " + integerList3);
    }
}
