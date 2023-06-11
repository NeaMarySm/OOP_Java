package telephone.implementations.mediaSender;

import telephone.interfaces.MediaSender;
import telephone.interfaces.Storable;
import telephone.models.Data;

public class PhotoSender<T extends Storable> implements MediaSender {
    private T device;
    @Override
    public void send() {
        Data photo = device.getStorage().get(0);
        System.out.println("sending photo " + photo.getName());
    }
}
