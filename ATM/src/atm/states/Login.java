/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.data.BankDatabaseImpl;
import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Login extends State{
    
    private final int BALANCE_INQUIRY = 1;
    private final int WITHDRAWAL = 2;
    private final int DEPOSIT = 3;
    private final int EXIT = 4;
    
    public Login(BankDatabaseImpl context) {
        super(context);
    }
    
    @Override 
    public boolean startTransaction(int type){
        return false;
    }
    
}
