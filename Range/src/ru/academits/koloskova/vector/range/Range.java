package ru.academits.koloskova.vector.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return ((x >= from) && (x <= to));
    }

    public Range getIntersection(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (minTo <= maxFrom) {
            return null;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) {
        double minTo = Math.min(to, range.to);
        double maxFrom = Math.max(from, range.from);

        double minFrom = Math.min(from, range.from);
        double maxTo = Math.max(to, range.to);
        if (minTo < maxFrom) {
            return new Range[]{new Range(minFrom, minTo), new Range(maxFrom, maxTo)};
        }

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (minTo <= maxFrom) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from) {
            if (to > range.to) {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }
            return new Range[]{new Range(from, range.from)};
        }

        if (to > range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{};
    }
}