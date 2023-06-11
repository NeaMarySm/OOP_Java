package telephone.implementations;

import telephone.interfaces.Photo;
import telephone.interfaces.Storable;
import telephone.models.Data;

public class PhotoImpl<T extends Storable> implements Photo {
    private T device;

    public PhotoImpl(T device) {
        this.device = device;
    }
    @Override
    public void takePhoto() {
        Data photo = new Data("ph_1","photo", 12 );
        device.store(photo);
    }
}
