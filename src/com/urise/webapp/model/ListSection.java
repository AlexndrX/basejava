package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSection extends AbstractSection{
    private final List<String> listAchievement = new ArrayList<>();

    public void setListAchievement(String achievement) {
        listAchievement.add(achievement);
    }

    @Override
    public String toString() {
        return listAchievement.toString();
    }
}
