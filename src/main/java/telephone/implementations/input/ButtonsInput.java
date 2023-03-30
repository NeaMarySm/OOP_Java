package telephone.implementations.input;

import telephone.interfaces.Input;

import java.util.Random;

public class ButtonsInput implements Input {
    @Override
    public String getInput() {
        return getInputFromButtons();
    }
    private String getInputFromButtons(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(100));
        }
        return sb.toString();
    }

}
