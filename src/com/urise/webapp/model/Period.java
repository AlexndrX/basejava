package com.urise.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Period implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final StringBuilder title;
    private final LocalDate start;
    private final LocalDate end;
    private StringBuilder description;

    public Period(StringBuilder title, LocalDate start, LocalDate end) {
        this.title = new StringBuilder(title);
        this.start = start;
        this.end = end;
    }

    public StringBuilder getTitle() {
        return title;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
        this.description = new StringBuilder(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (!title.equals(period.title)) return false;
        if (!start.equals(period.start)) return false;
        if (!end.equals(period.end)) return false;
        return description.equals(period.description);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return start.toString() + " - " + end.toString() + "               " + title
                + "\n" + "                               " + description + "\n";
    }
}
