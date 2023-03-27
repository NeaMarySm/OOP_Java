package phonebook.service.importer;

import java.io.IOException;

public interface Import {
    void importFile(String filename) throws IOException;
}
