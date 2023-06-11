package telephone;

import telephone.implementations.input.ButtonsInput;
import telephone.models.FixedPhone;
import telephone.models.Smartphone;
import telephone.models.Telephone;

public class Main {
    public static void main(String[] args) {
        Telephone samsungA000 = new Smartphone("A000","Samsung");
        samsungA000.call();
        Telephone homePhone = new FixedPhone("e2323","phillips",false, new ButtonsInput());
        homePhone.call();
    }
}
