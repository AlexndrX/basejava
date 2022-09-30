package com.urise.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Organization implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    String title;
    String webSite;
    List<Period> periods;

    public Organization(String title, Period... period) {
        this.title = title;
        //assert false;
        periods = new ArrayList<>();
        periods.addAll(Arrays.asList(period));
    }

    public String getTitle() {
        return title;
    }

    public String getWebSite() {
        return webSite;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!title.equals(that.title)) return false;
        if (!webSite.equals(that.webSite)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + webSite.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "\n" + title + "\n" + "\n" + periods.toString();
    }
}
