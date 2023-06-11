package telephone.implementations;

import telephone.interfaces.Internet;

public class WifiImpl implements Internet {
    private String networkName;
    private String password;
    private boolean wifiConnection = false;
    private boolean internetConnection = false;

    public WifiImpl(String networkName, String password) {
        this.networkName = networkName;
        this.password = password;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void connect() {
        internetConnection = true;
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        internetConnection = false;
        System.out.println("disconnected");
    }
}
