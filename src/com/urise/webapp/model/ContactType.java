package com.urise.webapp.model;

public enum ContactType {
    PHONE ("Тел.: "),
    SKYPE ("Skype: "),
    MAIL ("Почта: "),
    LINKEDIN ("LINKEDIN"),
    GITHUB ("GITHUB"),
    STACKOVERFLOW ("STACKOVERFLOW"),
    HOMEPAGE ("HOMEPAGE");

    private final String subTitle;

    ContactType(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
