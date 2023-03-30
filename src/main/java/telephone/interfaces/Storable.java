package telephone.interfaces;

import telephone.models.Data;

import java.util.ArrayList;

public interface Storable {
    void store(Data data);
    ArrayList<Data> getStorage();

}
