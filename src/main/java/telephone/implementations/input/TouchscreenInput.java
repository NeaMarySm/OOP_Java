package telephone.implementations.input;

import telephone.interfaces.Input;

import java.util.Random;

public class TouchscreenInput implements Input {
    @Override
    public String getInput() {
        return getInputFromTouchScreen();
    }
    private String getInputFromTouchScreen(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(100));
        }
        return sb.toString();
    }
}
