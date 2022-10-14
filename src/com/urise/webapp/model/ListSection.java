package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends AbstractSection {

    private static final long serialVersionUID = 1L;

    private final List<String> strings = new ArrayList<>();

    public ListSection() {
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(String achievement) {
        strings.add(achievement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return strings.equals(that.strings);
    }

    @Override
    public int hashCode() {
        return strings.hashCode();
    }

    @Override
    public String toString() {
        return strings.toString();
    }
}
