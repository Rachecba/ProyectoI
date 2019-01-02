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
public class Withdraw extends State{
    
    public Withdraw(BankDatabaseImpl context) {
        super(context);
    }
    
    @Override
    public boolean credit(int account, double amount){
        return false;
    }
    
}
