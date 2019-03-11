package com.golda.app.pvttraining.cw4;

public class Manager {
    private static final Manager ourInstance = new Manager();

    public void setCw4Activity(Cw4Activity cw4Activity) {
        this.cw4Activity = cw4Activity;
    }

    private Cw4Activity cw4Activity;

    public static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {
    }
}
