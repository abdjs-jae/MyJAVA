package semantics.symboltable;

/**
 * Created by jasonsapdos on 16/11/2017.
 */
public class SymbolTableManager {

    private static SymbolTableManager sharedInstance = null;

    public static SymbolTableManager getInstance() {
        return sharedInstance;
    }

}
