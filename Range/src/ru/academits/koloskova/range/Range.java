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

    public Range getIntersectionInterval(double from, double to) {
        if ((this.to < from) || (to < this.from)) {
            return null;
        }
        if (this.from > from) {
            from = this.from;
        }
        if (this.to < to) {
            to = this.to;
        }
        return new Range(from, to);
    }

    public Range[] getIntervalUnion(double from, double to) {
        Range[] ranges = new Range[2];

        if (this.to < from) {
            ranges[0] = new Range(this.from, this.to);
            ranges[1] = new Range(from, to);
            return ranges;
        } else if (to < this.from) {
            ranges[0] = new Range(from, to);
            ranges[1] = new Range(this.from, this.to);
            return ranges;
        }

        if (this.from < from) {
            from = this.from;
        }
        if (this.to > to) {
            to = this.to;
        }

        ranges[0] = new Range(from, to);
        ranges[1] = null;

        return ranges;
    }

    public Range[] getIntervalDifference(double from, double to) {
        Range[] ranges = new Range[2];

        if ((this.to < from) || (to < this.from)) {
            ranges[0] = new Range(this.from, this.to);
            ranges[1] = null;
            return ranges;
        }

        if (this.from < from) {
            ranges[0] = new Range(this.from, from);
            if (this.to > to) {
                ranges[1] = new Range(to, this.to);
            } else {
                ranges[1] = null;
            }
            return ranges;
        } else if (this.to > to) {
            ranges[0] = new Range(to, this.to);
            ranges[1] = null;
            return ranges;
        }

        return null;
    }
}