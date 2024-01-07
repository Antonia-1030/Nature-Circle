package com.myProject.Nature_Circle.models;

public enum OrderStatus {
    OPEN("Open"), PROCESSING("PROCESSING");
    private String translation;

    private OrderStatus(final String translation) {
        this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }
}
