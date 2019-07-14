package ru.academits.koloskova.range;

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
        if ((to <= range.from) || (range.to <= from)) {
            return null;
        }

        double maxFrom = range.from;
        double minTo = range.to;

        if (from > range.from) {
            maxFrom = from;
        }
        if (to < range.to) {
            minTo = to;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) { //лучше не менять аргументы
        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else if (range.to < from) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        double minFrom = range.from;
        double maxTo = range.to;

        if (from < range.from) {
            minFrom = from;
        }
        if (this.to > to) {
            maxTo = this.to;
        }

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        if ((to < range.from) || (range.to < from)) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from) {
            if (to > range.to) {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            } else {
                return new Range[]{new Range(from, range.from)};
            }
        } else if (to > range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{};
    }
}