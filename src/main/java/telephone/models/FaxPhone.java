package telephone.models;

import telephone.interfaces.Fax;
import telephone.interfaces.Input;


public class FaxPhone extends FixedPhone implements Fax {
    public FaxPhone(String model, String manufacturer, boolean display, Input input) {
        super(model, manufacturer, display, input);
    }

    @Override
    public void sendFax() {
        System.out.println("sending document");
    }

    @Override
    public void getFax() {
        System.out.println("getting document");
    }
}
