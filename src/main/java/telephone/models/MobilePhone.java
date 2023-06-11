package telephone.models;

import telephone.interfaces.Charging;
import telephone.interfaces.Input;
import telephone.models.Telephone;

public class MobilePhone extends Telephone implements Charging {
    protected int batteryCapacity;
    protected int currentBatteryCharge;
    protected boolean networkConnection = true;
    protected boolean power = true;
    protected String mobileOperator;

    public MobilePhone(String model, String manufacturer, boolean display, Input inputType) {
        super(model, manufacturer, display, inputType);
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getCurrentBatteryCharge() {
        return currentBatteryCharge;
    }

    public void setCurrentBatteryCharge(int currentBatteryCharge) {
        this.currentBatteryCharge = currentBatteryCharge;
    }

    public boolean isNetworkConnection() {
        return networkConnection;
    }

    public void toggleNetworkConnection(boolean networkConnection) {
        networkConnection = !networkConnection;
    }

    public boolean isPower() {
        return power;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public void togglePower() {
        power = !power;
        checkCharge();
    }
    private void checkCharge(){
        if(currentBatteryCharge == 0){
            power = false;
        }
}
    @Override
    public void call() {
        System.out.printf("%s %s makes call", manufacturer, model);
    }

    @Override
    public void response() {

    }

    @Override
    public void ring() {
        System.out.printf("%s %s makes call", manufacturer, model);
    }

    @Override
    public void charge() {
        setCurrentBatteryCharge(100);
    }
}
