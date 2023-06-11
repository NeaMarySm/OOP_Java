package telephone.implementations;

import telephone.interfaces.Internet;

public class MobileInternet implements Internet {
    private String network;

    public MobileInternet(String network) {
        this.network = network;
    }
    @Override
    public void connect() {

    }
    @Override
    public void disconnect() {

    }
}
