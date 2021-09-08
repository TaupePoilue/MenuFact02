package ingredients;

import java.util.Hashtable;

public class Storage {

    private static final class DeferredLoader {
        static final Storage INSTANCE = new Storage();
    }

    public static Storage getInstance() {
        return DeferredLoader.INSTANCE;
    }
}
