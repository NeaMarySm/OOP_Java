package telephone.models;

import telephone.implementations.MobileInternet;
import telephone.implementations.WifiImpl;
import telephone.implementations.input.TouchscreenInput;
import telephone.interfaces.Internet;
import telephone.interfaces.Storable;


import java.util.ArrayList;

public class Smartphone extends MobilePhone implements Storable {
    private ArrayList<Data> storage = new ArrayList<>();
    private WifiImpl wifi;
    private MobileInternet mobileInternet;
    private Internet currentInternetConnectionType;

    public Smartphone(String model, String manufacturer) {
        super(model, manufacturer, true, new TouchscreenInput());
        this.wifi = new WifiImpl("default","default");
        currentInternetConnectionType = wifi;
    }

    public void setStorage(ArrayList<Data> storage) {
        this.storage = storage;
    }

    public WifiImpl getWifi() {
        return wifi;
    }

    public void setWifi(WifiImpl wifi) {
        this.wifi = wifi;
    }

    public MobileInternet getMobileInternet() {
        return mobileInternet;
    }

    public void setMobileInternet(MobileInternet mobileInternet) {
        this.mobileInternet = mobileInternet;
    }

    public Internet getCurrentInternetConnectionType() {
        return currentInternetConnectionType;
    }

    public void setCurrentInternetConnectionType(Internet currentInternetConnectionType) {
        this.currentInternetConnectionType = currentInternetConnectionType;
    }

    @Override
    public void setMobileOperator(String mobileOperator) {
        super.setMobileOperator(mobileOperator);
        mobileInternet = new MobileInternet(mobileOperator);
    }

    @Override
    public void store(Data data) {
        storage.add(data);
    }

    @Override
    public ArrayList<Data> getStorage() {
        return storage;
    }
}
