
package atm.model;

import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public interface Cajero {
    
    void attach(Consumer<String> listener);
    void onInit();
    
    void message();
    void optionMenu();
    void authenticate();
    void transaction();
    void deposit();
    void withdrawal();
    void balance();
    void exit();
}
