
package atm.states;

import atm.data.BankDatabaseImpl;

/**
 *
 * @author Rachel
 */
public class Balance extends State{
    
    public Balance(BankDatabaseImpl context) {
        super(context);
    }
    
    @Override
    public double[] getBalance(int account){
        return null;
    }
    
}
