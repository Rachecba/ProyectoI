
package atm.model;

import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public interface Cajero {
    
    void attach(Consumer<String> listener);
    void onInit();
    
    void botones(int num);
    void execute(int num);
}
