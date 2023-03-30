package telephone.implementations.input;

import telephone.interfaces.Input;

import java.util.Random;

public class RotaryInput implements Input {
    @Override
    public String getInput() {
        return getInputFromRotary();
    }
    private String getInputFromRotary(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(100));
        }
        return sb.toString();
    }
}
