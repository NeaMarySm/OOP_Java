package telephone.models;

import telephone.interfaces.Input;

public class FixedPhone extends Telephone {
    private boolean power = true; // connection to the electricity
    private boolean wiredConnection = true; // connection to the phone network

    public FixedPhone(String model, String manufacturer, boolean display, Input input) {
        super(model, manufacturer, display, input);
    }

    public boolean isPower() {
        return power;
    }

    public void togglePower() {
        power = !power;
    }

    public boolean isWiredConnection() {
        return wiredConnection;
    }

    public void toggleWiredConnection() {
        wiredConnection = !wiredConnection;
    }

    @Override
    public void call() {
        if (power) {
            String phoneNumber = inputType.getInput();
            if (wiredConnection) {
                System.out.println("Calling " + phoneNumber);
            }
        }
    }

    @Override
    public void response() {
        if(power&&wiredConnection){
            System.out.println("Answering...");
        }
    }

    @Override
    public void ring() {
        System.out.println("Phone is ringing");
    }
}
