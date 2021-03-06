
package atm.model;

import atm.data.BankDatabase;
import atm.states.Login;
import atm.states.Start;
import atm.states.State;
import atm.view.CashDispenser;
import atm.view.DepositSlot;
import atm.view.Keypad;
import atm.view.Screen;


/**
 *
 * @author Rachel
 */
public class AtmImpl implements Atm {
    State state;
    BankDatabase dao;
    boolean authenticated;
    
    public AtmImpl(BankDatabase bd){
        this.dao = bd;
        this.authenticated = false;
        this.state= new Login(this);
    }
    
    public boolean getAuthenticated(){
        return this.authenticated;
    }
    
    public void setAuthenticated(boolean authenticated){
        this.authenticated = authenticated;
    }
    
    public State getState(){
        return this.state;
    }
    
    public void setState(State state){
        this.state = state;
    }
    
    public BankDatabase getDao(){
        return this.dao;
    }
    
    public void setDao(BankDatabase dao){
        this.dao = dao;
    }

    @Override
    public boolean authenticateUser(int account, int pin) {
        return state.authenticateUser(account, pin);
    }

    @Override
    public boolean startTransaction(int type) {
        return state.startTransaction(type);
    }

    @Override
    public boolean credit(int account, double amount) {
        return state.credit(account, amount);
    }

    @Override
    public boolean debit(int account, double amount) {
        return state.debit(account, amount);
    }

    @Override
    public double[] getBalance(int account) {
        return state.getBalance(account);
    }
    
}
