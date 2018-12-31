
package atm.model;

import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public interface Cajero {
    
    void attach(Consumer<String> listener);
    void onInit(); //inicializa
    
    void message();
    void input();
    void authenticate();
    void transaction(int num);
    void deposit();
    void withdrawal();
    void balance();
    void exit();
}
