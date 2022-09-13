package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizationSection extends AbstractSection {

    List<Organization> organizations = new ArrayList<>();

    public void setOrganizations(Organization... org) {
        organizations.addAll(Arrays.asList(org));
    }

    @Override
    public String toString() {
        return organizations.toString();
    }

    public static class Organization {
        String title;
        String webSite;
        List<Period> periods;

        public Organization(String title, Period period) {
            this.title = title;
            assert false;
            periods = new ArrayList<>();
            periods.add(period);
        }

        @Override
        public String toString() {
            return "\n" + "\n" + title + "\n" + "\n" + periods.toString();
        }
    }

    public static class Period {
        StringBuilder title;
        LocalDate start;
        LocalDate end;
        StringBuilder description;

        public Period(StringBuilder title, LocalDate start, LocalDate end) {
            this.title = new StringBuilder(title);
            this.start = start;
            this.end = end;
        }

        public void setDescription(StringBuilder description) {
            this.description = new StringBuilder(description);
        }

        @Override
        public String toString() {
            return start.toString() + " - " + end.toString() + "               " + title
                    + "\n" + "                               " + description + "\n";
        }
    }
}
