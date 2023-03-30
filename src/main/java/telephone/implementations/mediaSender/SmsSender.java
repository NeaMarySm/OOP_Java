package telephone.implementations.mediaSender;

import telephone.interfaces.MediaSender;
import telephone.models.Telephone;

public class SmsSender<T extends Telephone> implements MediaSender {
    private String message;


    public SmsSender(String message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("sending message: " + message);
    }
}
