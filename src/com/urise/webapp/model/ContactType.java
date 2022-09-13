package com.urise.webapp.model;

public enum ContactType {
    PHONE ("Тел.: "),
    SKYPE ("Skype: "),
    MAIL ("Почта: "),
    LINKEDIN (""),
    GITHUB (""),
    STACKOVERFLOW (""),
    HOMEPAGE ("");

    private String subTitle;

    ContactType(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
