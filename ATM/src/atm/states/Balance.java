
package atm.states;

import atm.model.CajeroImpl;

/**
 *
 * @author Rachel
 */
public class Balance extends State{
    
    public Balance(CajeroImpl atm){
        super(atm);
    }

    @Override
    public String authenticateUser() {
        return "Not available";
    }

    @Override
    public String performTransaction(int num) {
        return "Not available";
    }

    @Override
    public String message() {
        return "Not available";
    }

    @Override
    public int input() {
        return 0;
    }

    @Override
    public String balanceTransaction() {
        return "\n Balance information: " + "\n - Available balance:" + atm.getAvailableBalance() + "\n - Total balance: " + atm.getTotalBalance();
    }

    @Override
    public String withdrawalTransaction() {
        return "Not available";
    }

    @Override
    public String depositTransaction() {
        return "Not available";
    }

    @Override
    public String exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
