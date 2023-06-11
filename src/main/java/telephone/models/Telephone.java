package telephone.models;

import telephone.interfaces.Input;

public abstract class Telephone {
    protected String model;
    protected String manufacturer;
    protected boolean display;
    protected Input inputType;

    public Telephone(String model, String manufacturer, boolean display, Input inputType) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.display = display;
        this.inputType = inputType;
    }

    public abstract void call();

    public abstract void response();

    public abstract void ring();
}
