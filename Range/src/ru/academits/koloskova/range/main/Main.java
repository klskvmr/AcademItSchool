package ru.academits.koloskova.range.main;

import ru.academits.koloskova.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 2);
        System.out.println("Range1: [" + range.getFrom() + " , " + range.getTo() + "]");

        System.out.println("Interval length: " + range.getLength());

        double number = 7.5;
        System.out.println("Is number " + number + " inside range: " + range.isInside(7));

        Range rangeCheck = new Range(4, 6);
        System.out.println("Add Range2: [" + rangeCheck.getFrom() + " , " + rangeCheck.getTo() + "]");


        Range intersection = range.getIntersection(rangeCheck);
        System.out.print("Interval intersection: ");
        if (intersection == null) {
            System.out.println("null");
        } else {
            System.out.println("[" + intersection.getFrom() + " , " + intersection.getTo() + "]");
        }

        Range[] ranges = range.getUnion(rangeCheck);
        System.out.print("Interval union: ");
        for (Range iRange : ranges) {
            System.out.print("[" + iRange.getFrom() + " , " + iRange.getTo() + "] ");
        }
        System.out.println();

        System.out.print("Interval difference: ");
        ranges = range.getDifference(rangeCheck);
        for (Range iRange : ranges) {
            System.out.print("[" + iRange.getFrom() + " , " + iRange.getTo() + "] ");
        }
    }
}