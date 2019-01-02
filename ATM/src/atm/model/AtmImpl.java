
package atm.model;

import atm.data.BankDatabase;
import atm.states.State;


/**
 *
 * @author Rachel
 */
public class AtmImpl implements Atm {
    State state;
    BankDatabase dao;
    boolean authenticated;
    
    public AtmImpl(){
    
    }

    @Override
    public boolean authenticateUser(int account, int pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean startTransaction(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean credit(int account, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean debit(int account, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getBalance(int account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
