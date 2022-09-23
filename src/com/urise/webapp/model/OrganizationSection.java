package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizationSection extends AbstractSection {

    private final List<Organization> organizations = new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization... org) {
        organizations.addAll(Arrays.asList(org));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
