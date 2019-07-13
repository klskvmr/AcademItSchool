package ru.academits.koloskova.range.main;

import ru.academits.koloskova.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 2);
        System.out.println("Range: [" + range.getFrom() + " , " + range.getTo() + "]");

        System.out.println("Interval length: " + range.getLength());

        double number = 7.5;
        System.out.println("Is number " + number + " inside range: " + range.isInside(7));

        Range intersectionRange = range.getIntersectionInterval(3, 6);
        System.out.print("Interval intersection: ");
        if (intersectionRange == null) {
            System.out.println("null");
        } else {
            System.out.println(intersectionRange.getFrom() + " " + intersectionRange.getTo());
        }

        Range[] ranges = range.getIntervalUnion(8, 9);
        System.out.print("Interval union: ");
        for (int i = 0; i < 2; i++) {
            if (ranges[i] == null) {
                break;
            }
            System.out.print("[" + ranges[i].getFrom() + " , " + ranges[i].getTo() + "] ");
        }
        System.out.println();

        ranges = range.getIntervalDifference(1, 3);
        System.out.print("Interval difference: ");
        if (ranges == null) {
            System.out.println("null");
        } else {
            for (int i = 0; i < 2; i++) {
                if (ranges[i] == null) {
                    break;
                }
                System.out.print("[" + ranges[i].getFrom() + " , " + ranges[i].getTo() + "] ");
            }
        }
    }
}