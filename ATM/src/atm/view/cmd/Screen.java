
package atm.view.cmd;

/**
 *
 * @author Rachel
 */
public class Screen implements atm.view.Screen{

    @Override
    public void displayDollarAmount(double amount) {
        System.out.printf( "$%,.2f", amount );   
    }

    @Override
    public void displayMessage(String message) {
        System.out.println( message );
    }

    @Override
    public void displayMessageLine(String message) {
        System.out.println( message );
    }
    
    
    
}
