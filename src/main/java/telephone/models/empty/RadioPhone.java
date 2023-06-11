package telephone.models.empty;

import telephone.interfaces.Charging;
import telephone.interfaces.Input;
import telephone.models.FixedPhone;

public class RadioPhone extends FixedPhone {
    public RadioPhone(String model, String manufacturer, boolean display, Input input) {
        super(model, manufacturer, display, input);
    }

    private class Base{}
    private class Handset implements Charging {

        @Override
        public void charge() {

        }
    }
}
